package com.example.interface_bliblioteca.Bibliotecas.Usuarios.adm.Cadastro;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "usuarios")
public class Cadastro_entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Login",nullable = false)
    private String senha;
    @Column(name = "senha",nullable = false)
    private String login;
    @Column(name = "date_nascimento")
    private LocalDate dateNascimento;
    @Column(name = "cpf",nullable = false)
    private int cpf;
    @Column(name = "adm",nullable = false)
    private boolean adm;

    public String getSenha() {
        return senha;
    }


    public LocalDate getDateNascimento() {
        return dateNascimento;
    }

    public void setDateNascimento(LocalDate dateNascimento) {
        this.dateNascimento = dateNascimento;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
}
