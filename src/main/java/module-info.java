module com.example.interface_bliblioteca {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens com.example.interface_bliblioteca to javafx.fxml;
    exports com.example.interface_bliblioteca;
}