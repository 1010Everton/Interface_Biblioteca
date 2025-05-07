package com.example.interface_bliblioteca.Bibliotecas.Campo_de_login;

import com.example.interface_bliblioteca.Bibliotecas.Usuarios.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.util.List;
import java.util.Scanner;

public class Faz_login {


    public boolean Login(String login, String senha) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtos");
        EntityManager em = emf.createEntityManager();
        boolean sucesso = false;

        try {
            TypedQuery<Usuario> busca = em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha", Usuario.class
            );
            busca.setParameter("login", login);
            busca.setParameter("senha", senha);

            List<Usuario> resultados = busca.getResultList();

            if (!resultados.isEmpty()) {
                Usuario usuarioDoBanco = resultados.get(0); // Pegando o primeiro registro
                if (login.equals(usuarioDoBanco.getLogin()) && senha.equals(usuarioDoBanco.getSenha())) {
                    sucesso=true;
                } else {
                    sucesso=false;
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    return sucesso; }
}
