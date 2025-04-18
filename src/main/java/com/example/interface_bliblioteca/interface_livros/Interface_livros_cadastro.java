package com.example.interface_bliblioteca.interface_livros;

import com.example.interface_bliblioteca.Bibliotecas.Campo_de_login.Cadastro_usuario;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.stream.IntStream;

public class Interface_livros_cadastro {
    public void Cadastro(Stage stage) throws IOException {
        Label Login = new Label("Login");
        TextField TEXTO = new TextField();
        Label Senha = new Label("senha");
        TextField TEXTO2 = new TextField();

        Label cpf = new Label("cpf");
        TextField TEXTO4 = new TextField();

        ComboBox<Integer> dayComboBox = new ComboBox<>();
        IntStream.rangeClosed(1, 31).forEach(dayComboBox.getItems()::add);

        // ComboBox para o mês
        ComboBox<String> monthComboBox = new ComboBox<>();
        monthComboBox.getItems().addAll(
                "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
        );

        // ComboBox para o ano
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        IntStream.rangeClosed(1900, 2100).forEach(yearComboBox.getItems()::add);

        // Layout horizontal
        HBox hbox = new HBox(10, dayComboBox, monthComboBox, yearComboBox);

        Label nascimento = new Label("nascimento");
        String cpfus = TEXTO4.getText();
        String fazlogin = TEXTO.getText();
        String Senhalogin = TEXTO2.getText();
        Button Botao_confirma = new Button("confirmar");

        Integer dia = dayComboBox.getValue();
        String mes = monthComboBox.getValue();
        Integer ano = yearComboBox.getValue();
        String data = dia+"/"+mes+"/"+ano;

        Botao_confirma.setOnAction(actionEvent -> {Cadastro_usuario login = new Cadastro_usuario();
        login.cadastrarUsuario(fazlogin,Senhalogin,cpfus,data);
        });
        String dataNascimento = "";
        if (dia != null && mes != null && ano != null) {
            dataNascimento = dia + " de " + mes + " de " + ano;
        }


        VBox box = new VBox();
        box.setSpacing(10);
        box.getChildren().addAll(
                Login, TEXTO,
                Senha, TEXTO2,
                nascimento,hbox,
                cpf, TEXTO4,
                Botao_confirma
        );

        Scene cena = new Scene(box,400,400);
        cena.getStylesheets().add("Estilos.css");
        stage.setScene(cena);
        stage.show();
    }
}
