package com.example.base_3;

import java.sql.*;

public class DatabaseConnetor {
    public Connection dbConnection = getDBConnection();



    public Connection getDBConnection()
    {
        Connection db;
        String location = DatabaseConnetor.class.getResource("database/base.db").toExternalForm();
        System.out.println(location);
        try {
            db = DriverManager.getConnection("jdbc:sqlite:" + location);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("подключена");
        return db;
    }

    public  void CreateDB() {
        PreparedStatement pstmt = null;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'users'('id' integer primary key autoincrement," +
                    "'name' text not null," +
                    "'telephone' text not null);");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("таблица создана");
    }
}
