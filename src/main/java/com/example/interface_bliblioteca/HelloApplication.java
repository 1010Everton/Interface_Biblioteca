package com.example.interface_bliblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label Login = new Label("Login");
        TextField TEXTO = new TextField();
        Label Senha = new Label("senha");
        TextField TEXTO2 = new TextField();

        Button Botao_confirma = new Button("confirmar");


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

    public static void main(String[] args) {
        launch();
    }
}