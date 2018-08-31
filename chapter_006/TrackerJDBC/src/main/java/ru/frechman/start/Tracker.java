package ru.frechman.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.frechman.models.Item;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The class implements a tracking system.
 */
public class Tracker implements AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Tracker.class);

    private Connection connection;

    public Tracker(File config) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(config)) {
            prop.load(fis);

            String url = prop.getProperty("database.url");
            String username = prop.getProperty("database.username");
            String password = prop.getProperty("database.password");
            boolean autocommit = Boolean.parseBoolean(prop.getProperty("database.autocommit"));
            String pathTableCreate = prop.getProperty("sql.create_table_path");

            this.connection = DriverManager.getConnection(url, username, password);
            createTable(pathTableCreate);
            this.connection.setAutoCommit(autocommit);

        } catch (IOException e) {
            System.out.println("Файл настроек не найден!");
            LOGGER.error(e.getMessage(), e);
        } catch (SQLException e) {
            System.out.println("Нет соединения!");
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Создает таблицу.
     * SQL должен быть написан с проверкой того, что существует ли уже таблица.
     *
     * @param pathFile путь до файла в котором написан sql запрос создания таблицы.
     * @throws SQLException
     * @throws IOException
     */
    private void createTable(String pathFile) throws SQLException, IOException {
        Path path = Paths.get(pathFile);
        try (Statement st = this.connection.createStatement()) {
            st.executeUpdate(new String(Files.readAllBytes(path), StandardCharsets.UTF_8));
        }
    }

    /**
     * Add item to array.
     *
     * @param item New item.
     * @return this item.
     */
    public Item add(Item item) {
        String query =
                "INSERT INTO Items(name, description, create_date) VALUES (?,?,?)";
        try (PreparedStatement st =
                     this.connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setTimestamp(3, new Timestamp(item.getCreateDate()));
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            while (generatedKeys.next()) {
                item.setId(String.valueOf(generatedKeys.getInt(1)));
            }
            generatedKeys.close();
            this.connection.commit();
            return item;
        } catch (SQLException e) {
            try {
                this.connection.rollback();
                LOGGER.error(e.getMessage(), e);
            } catch (SQLException e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
        }
        return item;
    }

    /**
     * Edit item.
     *
     * @param id   Id edit item.
     * @param item New edited item.
     */
    public void edit(String id, Item item) {
        String query
                = "UPDATE Items SET name = ?, description = ?, create_date = ? WHERE id = ?";
        try (PreparedStatement st = this.connection.prepareStatement(query)) {
            st.setString(1, item.getName());
            st.setString(2, item.getDescription());
            st.setTimestamp(3, new Timestamp(item.getCreateDate()));
            st.setInt(4, Integer.parseInt(id));

            st.executeUpdate();
            this.connection.commit();
        } catch (SQLException e) {
            try {
                this.connection.rollback();
                LOGGER.error(e.getMessage(), e);
            } catch (SQLException e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
        }
    }

    /**
     * Delete item.
     *
     * @param id Id item.
     */
    public void delete(String id) {
        String query = "DELETE FROM Items WHERE id= ?";
        try (PreparedStatement st = this.connection.prepareStatement(query)) {
            st.setInt(1, Integer.parseInt(id));

            st.executeUpdate();
            this.connection.commit();
        } catch (SQLException e) {
            try {
                this.connection.rollback();
                LOGGER.error(e.getMessage(), e);
            } catch (SQLException e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
        }
    }

    /**
     * Find all item.
     *
     * @return Copy List of Items without null-elements.
     */
    public List<Item> findAll() {
        List<Item> resultArrItems = new ArrayList<>();

        String query = "SELECT * FROM Items";
        try (PreparedStatement st = this.connection.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {

            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                long create_date = rs.getTimestamp("create_date").getTime();
                Item item = new Item(name, description, create_date);
                item.setId(id);

                resultArrItems.add(item);
            }
            this.connection.commit();
            return resultArrItems;
        } catch (SQLException e) {
            try {
                this.connection.rollback();
                LOGGER.error(e.getMessage(), e);
            } catch (SQLException e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
        }
        return resultArrItems;
    }

    /**
     * All items.
     *
     * @return List of Items all item.
     */
    public List<Item> getAll() {
        return findAll();
    }

    /**
     * Find item by id.
     *
     * @param id Desired id of item.
     * @return Found item.
     */
    public Item findById(String id) {
        String query = "SELECT * FROM Items WHERE id = ?";
        Item foundItem = null;
        try (PreparedStatement st = this.connection.prepareStatement(query)) {
            st.setInt(1, Integer.parseInt(id));
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                long create_date = rs.getTimestamp("create_date").getTime();
                Item item = new Item(name, description, create_date);
                item.setId(id);
                foundItem = item;
            }
            rs.close();
            this.connection.commit();
            return foundItem;
        } catch (SQLException e) {
            try {
                this.connection.rollback();
                LOGGER.error(e.getMessage(), e);
            } catch (SQLException e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
        }
        return foundItem;
    }

    /**
     * Find item by item's name.
     *
     * @param name Desired name of item.
     * @return List of Items found items.
     */
    public List<Item> findByName(String name) {
        List<Item> resultArrItems = new ArrayList<>();

        String query = "SELECT * FROM Items WHERE name = ?";
        try (PreparedStatement st = this.connection.prepareStatement(query)) {
            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String description = rs.getString("description");
                long create_date = rs.getTimestamp("create_date").getTime();
                Item item = new Item(name, description, create_date);
                item.setId(id);

                resultArrItems.add(item);
            }
            rs.close();
            this.connection.commit();
            return resultArrItems;
        } catch (SQLException e) {
            try {
                this.connection.rollback();
                LOGGER.error(e.getMessage(), e);
            } catch (SQLException e1) {
                LOGGER.error(e1.getMessage(), e1);
            }
        }

        return resultArrItems;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
    }
}