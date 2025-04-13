package com.example.interface_bliblioteca.Bibliotecas.Usuarios;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Login",nullable = false)
    private String login;
    @Column(name = "senha",nullable = false)
    private String senha;
    @Column(name = "data_nascimento",nullable = false)
    private LocalDate Data_nascimento;
    @Column(name = "cpf",nullable = false)
    private String cpf;
    @Column(name = "adm",nullable = false)
    private boolean adm ;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getData_nascimento() {
        return Data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        Data_nascimento = data_nascimento;
    }
    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
