package com.example.interface_bliblioteca.Bibliotecas.Campo_de_login;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Login",nullable = false)
    private String login;
    @Column(name = "senha",nullable = false)
    private String senha;
    @Column(name = "Adm",nullable = false)
    private boolean Adm;

    public boolean getAdm() {
        return Adm;
    }

    public void setAdm(boolean adm) {
        Adm = adm;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

}
