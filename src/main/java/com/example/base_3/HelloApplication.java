package com.example.base_3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //launch();
        DatabaseConnetor ql = new DatabaseConnetor();
        //ql.inserting_data("Marina", 5678);
        //ql.getUserData();
        //ql.inserting_products("рис", 34678);
        //ql.getUserProducts();
        //ql.userName("Marina");
        //ql.inserting_users_product(1, 4);
        //ql.getUsers_Products();
        //ql.getUser_Products();
        //ql.getUserProducts_price(17);
    }
}