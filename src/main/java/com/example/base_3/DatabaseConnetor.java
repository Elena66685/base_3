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

    public  void createDB()
    {
        PreparedStatement pstmt;
        try {
            pstmt = dbConnection.prepareStatement("CREATE TABLE IF NOT EXISTS" +
                    "'products'(id integer primary key autoincrement," +
                    "name text not null," +
                    "price integer not null);");
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

    public void getUserData() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM users");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString (2));
            System.out.println(resultSet.getString (3));
        }
    }

    public void inserting_data(String name, Integer telephone) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("INSERT INTO users (name, telephone) values ('"+name+"', "+telephone+");");
        pstmt.executeUpdate();

    }

    public void inserting_products(String name, Integer price) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("INSERT INTO products (name, price) values ('"+name+"', "+price+");");
        pstmt.executeUpdate();

    }

    public void getUserProducts() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM products");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString (2));
            System.out.println(resultSet.getString (3));
        }
    }

    public void userName(String name) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("SELECT * FROM users where name = '"+name+"';");
        ResultSet resultSet = pstmt.executeQuery();

        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString (2));
            System.out.println(resultSet.getString (3));
        }

    }

    public void inserting_users_product(Integer users_id, Integer product_id) throws SQLException {
        PreparedStatement pstmt = null;
        pstmt = dbConnection.prepareStatement("INSERT INTO users_product (users_id, product_id) values ('"+users_id+"', "+product_id+");");
        pstmt.executeUpdate();

    }

    public void getUsers_Products() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT users.name, products.name FROM users INNER JOIN users_product ON users_product.users_id = users.id INNER JOIN products ON users_product.product_id = products.id;");

        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next())
        {
            System.out.println(resultSet.getString (1));
            System.out.println(resultSet.getString (2));
        }
    }
    public void getUser_Products() throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM users_product");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getInt(2));
        }
    }

    public void getUserProducts_price(Integer price) throws SQLException {
        PreparedStatement stmt = dbConnection.prepareStatement("SELECT * FROM products where price = '"+price+"';");
        ResultSet resultSet = stmt.executeQuery();

        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1));
            System.out.println(resultSet.getString (2));
            System.out.println(resultSet.getInt (3));
        }
    }
}
