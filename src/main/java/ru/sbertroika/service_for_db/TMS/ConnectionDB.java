package ru.sbertroika.service_for_db.TMS;

import java.sql.*;

public class ConnectionDB {
    private Connection connection;
    public ConnectionDB() {
        try {
            getDBConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private void getDBConnection() throws SQLException {
        connection = DriverManager.getConnection(DBConfig.getDbUrl(), DBConfig.getBdLogin(), DBConfig.getBdPass());
    }

}
