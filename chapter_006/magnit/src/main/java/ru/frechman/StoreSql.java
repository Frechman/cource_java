package ru.frechman;

import ru.frechman.config.Config;
import ru.frechman.model.Entry;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StoreSql implements AutoCloseable {

    private final static Random RN = new Random(System.currentTimeMillis());
    private Connection connection;

    public StoreSql(Config config) {
        try {
            this.connection = config.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable() throws Exception {
        try (Statement stmt = this.connection.createStatement()) {
            URI file = getClass().getClassLoader().getResource("sql/create.sql").toURI();
            stmt.executeUpdate(new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8));
            this.connection.commit();
        }
    }

    public void cleanTable() {
        String sql = "DELETE FROM entry";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.executeUpdate(sql);
            this.connection.commit();
        } catch (SQLException e) {
            try {
                this.connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    /**
     * Генерирует n записей в БД.
     *
     * @param n колличество записей.
     */
    public void generate(int n) {
        String sql = "INSERT INTO entry VALUES (?)";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            for (int i = 0; i < n; i++) {
                stmt.setInt(1, 1 + RN.nextInt(n));
                stmt.addBatch();
            }
            stmt.executeBatch();
            this.connection.commit();
            stmt.clearBatch();
        } catch (SQLException e) {
            try {
                this.connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public List<Entry> getAll() {
        List<Entry> result = new LinkedList<>();

        String sql = "SELECT * FROM entry";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rstSet = stmt.executeQuery();
            while (rstSet.next()) {
                int field = rstSet.getInt("field");
                Entry entry = new Entry(field);
                result.add(entry);
            }
            this.connection.commit();
            rstSet.close();

            return result;
        } catch (SQLException e) {
            try {
                this.connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void close() throws Exception {
        this.connection.close();
    }

}
