package ru.frechman.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {

    private Connection connection;

    public Config() {
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:magnit.sqlite";
        this.connection = DriverManager.getConnection(url);
        this.connection.setAutoCommit(false);
        return connection;
    }

}
