package com.example.interface_bliblioteca;
import com.example.interface_bliblioteca.interface_livros.Interface_livros_login;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Interface_livros_login Login = new Interface_livros_login();
        Login.Cadastro(primaryStage);
    }


    public static void main(String[] args) {
        launch();
    }
}