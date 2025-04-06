package com.example.interface_bliblioteca.Bibliotecas.Campo_de_login;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.example.Bibliotecas.Usuarios.Usuario;
import java.util.List;


import java.util.Scanner;

public class Faz_login {
    Scanner scan = new Scanner(System.in);

    public void Login() {
        System.out.print("Digite seu login: ");
        String login = scan.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scan.nextLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtos");
        EntityManager em = emf.createEntityManager();

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
                    System.out.println("Login realizado com sucesso!");
                } else {
                    System.out.println("Login ou senha incorretos.");
                }
            } else {
                System.out.println("Login ou senha incorretos.");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
