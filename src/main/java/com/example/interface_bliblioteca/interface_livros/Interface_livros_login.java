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
        Button Botão_cadastro = new Button("cadastro");
        Botao_confirma.setOnAction(actionEvent -> {login.Login(fazlogin,Senhalogin);});
        Interface_livros_cadastro cadastro = new Interface_livros_cadastro();

        Botão_cadastro.setOnAction(e->{
            try{
                cadastro.Cadastro(stage);
            }
            catch (Exception x){
                System.out.print(x);
            }

        });



        VBox box = new VBox();
        box.setSpacing(10);
        box.getChildren().addAll(
                Login,
                TEXTO,
                Senha,
                TEXTO2,
                Botao_confirma,
                Botão_cadastro
        );
        Scene cena = new Scene(box,400,400);
        cena.getStylesheets().add("Estilos.css");
        stage.setScene(cena);
        stage.show();
    }
}
