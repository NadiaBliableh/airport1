module com.example.test {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.desktop;
    requires jdk.jdi;

    opens com.example.test to javafx.fxml;
    exports com.example.test;
}