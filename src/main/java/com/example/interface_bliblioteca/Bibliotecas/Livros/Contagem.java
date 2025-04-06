package com.example.interface_bliblioteca.Bibliotecas.Livros;

public enum Contagem {
    UM(1),
    DOIS(2),
    TRES(3);

    private final int numero;

    // Construtor
    Contagem(int numero) {
        this.numero = numero;
    }

    // Método para acessar o valor
    public int getNumero() {
        return numero;
    }
    public void Contador (){
        for (Contagem contagem : Contagem.values()){
            System.out.println("Contagem: " + contagem + " tem o número: " + contagem.getNumero());
        }
    }
}

