package com.example.interface_bliblioteca.Bibliotecas.Livros;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import java.util.Scanner;

public class Cadastra_livro {
    public void cadastrar(){
    Scanner scan = new Scanner(System.in);
        System.out.print("digite o nome do livro : ");
    String nome = scan.nextLine();
        System.out.print("digite o nome do autor : ");
    String autor = scan.nextLine();
        System.out.print("digite o resumo : ");
    String resumo = scan.nextLine();



    EntityManagerFactory em = Persistence.createEntityManagerFactory("produtos");
    EntityManager emf = em.createEntityManager();


        emf.getTransaction().begin();

        emf.getTransaction().commit();
        emf.close();
        em.close();
        scan.close();

}
}
