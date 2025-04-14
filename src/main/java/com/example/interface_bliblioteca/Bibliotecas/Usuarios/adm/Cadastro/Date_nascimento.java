package com.example.interface_bliblioteca.Bibliotecas.Usuarios.adm.Cadastro;

import java.util.Date;

public class Date_nascimento {
    private int dia;
    private int mes;
    private int ano;

    public Date_nascimento(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    @Override
    public String toString() {
        String data1 = String.valueOf(dia);
        String data2 = String.valueOf(mes);
        String data3 = String.valueOf(ano);
        return data1+"/"+data2+"/"+data3 ;
    }
}
