package com.example.interface_bliblioteca.interface_livros;

import com.example.interface_bliblioteca.Bibliotecas.Campo_de_login.Faz_login;
import com.example.interface_bliblioteca.Bibliotecas.OpenLibrary.Conection;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.boot.archive.scan.spi.ScanEnvironment;

import java.io.IOException;
import java.util.Scanner;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Interface_livros_consultar {
    public void Cadastro(Stage stage) throws IOException {
        Label buscar = new Label("Pesquise o livro");
        TextField consulta = new TextField();

        TextArea resultadoArea = new TextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setWrapText(true);

        Button Botao_confirma = new Button("confirmar");
        Button Botao_voltar = new Button("voltar para o login");

        Botao_confirma.setOnAction(actionEvent -> {
            String tituloDigitado = consulta.getText();

            Conection pesquisa = new Conection();
            String resultado = pesquisa.buscarLivros(tituloDigitado);

            resultadoArea.setText(resultado);
        });

        Botao_voltar.setOnAction(actionEvent -> {
            Interface_livros_login login = new Interface_livros_login();
            try {
                login.Cadastro(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        VBox box = new VBox();
        box.setSpacing(10);
        box.getChildren().addAll(
                buscar,
                consulta,
                Botao_confirma,
                resultadoArea,  // <- exibe a resposta da API
                Botao_voltar
        );

        Scene cena = new Scene(box, 400, 400);
        cena.getStylesheets().add("Estilos.css");
        stage.setScene(cena);
        stage.show();
    }
}
