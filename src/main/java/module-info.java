open module Interface.Bliblioteca {
    exports com.example.interface_bliblioteca to javafx.graphics;
    exports com.example.interface_bliblioteca.Bibliotecas.Campo_de_login;
    exports com.example.interface_bliblioteca.interface_livros;
    exports com.example.interface_bliblioteca.Bibliotecas.Usuarios;

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires jakarta.persistence;
    requires com.google.gson;
    requires org.hibernate.orm.core;
}
