module Interface.Bliblioteca {
    requires javafx.graphics;
    requires javafx.controls;
    requires jakarta.persistence;
    requires com.google.gson;
    requires javafx.fxml;
    requires org.hibernate.orm.core;

    opens com.example.interface_bliblioteca.Bibliotecas.Livros to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Usuarios to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Usuarios.adm to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Campo_de_login to org.hibernate.orm.core;
}