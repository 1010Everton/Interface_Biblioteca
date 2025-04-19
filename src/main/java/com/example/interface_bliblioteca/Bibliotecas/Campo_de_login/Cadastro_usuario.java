package com.example.interface_bliblioteca.Bibliotecas.Campo_de_login;

import com.example.interface_bliblioteca.Bibliotecas.Usuarios.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Cadastro_usuario {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtos");
    EntityManager em = emf.createEntityManager();

    public void cadastrarUsuario(String login, String senha, String cpf, LocalDate data) {
        EntityTransaction transaction = em.getTransaction();

        try {
            // Inicia a transação
            transaction.begin();

            // Cria e configura a entidade
            Usuario usuario = new Usuario();
            usuario.setSenha(senha);
            usuario.setCpf(cpf);
            usuario.setLogin(login);
            usuario.setData_nascimento(data);

            // Persiste a entidade
            em.persist(usuario);

            // Confirma a transação
            transaction.commit();

        } catch (Exception e) {
            // Realiza rollback em caso de erro
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace(); // Exibe o erro no console para diagnóstico

        } finally {
            // Fecha os recursos no bloco 'finally'
            em.close();
            emf.close();
        }
    }
}