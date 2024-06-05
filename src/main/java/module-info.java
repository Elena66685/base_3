module com.example.base_3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.xerial.sqlitejdbc;


    opens com.example.base_3 to javafx.fxml;
    exports com.example.base_3;
}