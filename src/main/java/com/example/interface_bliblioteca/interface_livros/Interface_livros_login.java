package com.example.interface_bliblioteca.interface_livros;

import com.example.interface_bliblioteca.Bibliotecas.Campo_de_login.Faz_login;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Interface_livros_login {
    public void Cadastro(Stage stage) throws IOException {
        Faz_login login = new Faz_login();
        Label Login = new Label("Login");
        TextField TEXTO = new TextField();
        Label Senha = new Label("senha");
        TextField TEXTO2 = new TextField();
        String fazlogin = TEXTO.getText();
        String Senhalogin = TEXTO2.getText();

        Button Botao_confirma = new Button("confirmar");
        Botao_confirma.setOnAction(actionEvent -> {login.Login(fazlogin,Senhalogin);});

        VBox box = new VBox();
        box.setSpacing(10);
        box.getChildren().add(Login);
        box.getChildren().add(TEXTO);
        box.getChildren().add(Senha);
        box.getChildren().add(TEXTO2);
        box.getChildren().add(Botao_confirma);

        Scene cena = new Scene(box,400,400);
        cena.getStylesheets().add("Estilos.css");
        stage.setScene(cena);
        stage.show();
    }
}
