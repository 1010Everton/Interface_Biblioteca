package com.example.interface_bliblioteca.Bibliotecas.Usuarios.adm.Cadastro;

import com.example.interface_bliblioteca.Bibliotecas.Usuarios.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;


import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Cadastra_Login {
    public void cadastrar() {
        Scanner scan = new Scanner(System.in);

        try {
            System.out.print("Digite seu Login: ");
            String login = scan.nextLine();
            System.out.print("Digite sua senha: ");
            String senha = scan.nextLine();
            System.out.print("Digite a senha de confirmação : ");
            String confirmasenha = scan.nextLine();
            System.out.print("Digite seu cpf : ");
            String cpf = scan.nextLine();
            System.out.print("Digite sua data de nascimento: ");
            String dataInput = scan.nextLine();


            if (!Objects.equals(senha, confirmasenha)) {
                System.out.print("as suas senhas são diferentes");

            } else {


                EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtos");
                EntityManager em = emf.createEntityManager();

                try {
                    em.getTransaction().begin();

                    // Consulta personalizada para verificar se o login já existe
                    TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class);
                    query.setParameter("login", login);
                    Usuario usuarioExistente = query.getResultStream().findFirst().orElse(null);

                    if (usuarioExistente != null) {
                        System.out.println("Usuário já cadastrado!");
                    } else {
                        Usuario usuario = new Usuario();
                        usuario.setLogin(login);
                        usuario.setSenha(senha);
                        //usuario.setCpf(cpf);
                        usuario.setData_nascimento(LocalDate.parse(dataInput));
                        usuario.setAdm(false); // Define valor padrão para o campo "adm"

                        em.persist(usuario);
                        System.out.println("Usuário cadastrado com sucesso!");
                    }

                    em.getTransaction().commit();
                } catch (Exception e) {
                    em.getTransaction().rollback(); // Rollback em caso de erro
                    System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
                    e.printStackTrace(); // Mostra a stack trace para debug
                } finally {
                    em.close();
                    emf.close();
                }}
            } finally{
                scan.close(); // Fecha o Scanner
            }

    }
}


