package com.example.interface_bliblioteca.Bibliotecas.Livros;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "titulo", nullable = false,length = 100,unique = true)
    private String nome;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false)
    @Lob
    private String resumo;
    @Temporal(TemporalType.DATE)
    private Date Datadepublicacao;
    @Enumerated(EnumType.ORDINAL)
    private Contagem paginaslidas;
    @Enumerated(EnumType.ORDINAL)
    private Contagem visualizacoes;


    public Livros(String nome, String autor, String resumo) {
        this.nome = nome;
        this.autor = autor;
        this.resumo = resumo;
    }

    public Contagem getPaginaslidas() {
        return paginaslidas;
    }

    public void setPaginaslidas(Contagem paginaslidas) {
        this.paginaslidas = paginaslidas;
    }

    public Contagem getVisualizacoes() {
        return visualizacoes;
    }

    public void setVisualizacoes(Contagem visualizacoes) {
        this.visualizacoes = visualizacoes;
    }

    public Date getDatadepublicacao() {
        return Datadepublicacao;
    }

    public void setDatadepublicacao(Date datadepublicacao) {
        Datadepublicacao = datadepublicacao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


}
