package com.example.interface_bliblioteca;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Label Login = new Label("Login");
        Label Senha = new Label("senha");

        Button Botao_confirma = new Button();


        VBox box = new VBox();
        box.getChildren().add(Login);
        box.getChildren().add(Senha);
        box.getChildren().add(Botao_confirma);

        Scene cena = new Scene(box,400,400);
        stage.setScene(cena);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}