module Interface.Bliblioteca {
    exports com.example.interface_bliblioteca to javafx.graphics;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires jakarta.persistence;
    requires com.google.gson;
    requires org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Livros to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Usuarios to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Usuarios.adm to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Campo_de_login to org.hibernate.orm.core;
    opens com.example.interface_bliblioteca.Bibliotecas.Usuarios.adm.Cadastro to org.hibernate.orm.core;
}