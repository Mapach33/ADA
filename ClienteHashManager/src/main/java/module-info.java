module org.example.clientehashmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    opens org.example.clientehashmanager to javafx.fxml;
    exports org.example.clientehashmanager;
}