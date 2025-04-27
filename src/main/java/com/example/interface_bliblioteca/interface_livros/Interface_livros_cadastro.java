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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.stream.IntStream;

public class Interface_livros_cadastro {
    public void Cadastro(Stage stage) throws IOException {
        Label Login = new Label("Login");
        TextField TEXTO = new TextField();
        Label Senha = new Label("senha");
        TextField TEXTO2 = new TextField();
        Label cpf = new Label("cpf");
        TextField TEXTO4 = new TextField();

        Button botao_voltar = new Button("volta");
        Interface_livros_login volta_login = new Interface_livros_login();


        botao_voltar.setOnAction(e->{
            try{
                volta_login.Cadastro(stage);
            }
            catch (Exception x){
                System.out.print(x);
            }
        });


        ComboBox<Integer> dayComboBox = new ComboBox<>();
        IntStream.rangeClosed(1, 31).forEach(dayComboBox.getItems()::add);
        // ComboBox para o mês
        ComboBox<Integer> monthComboBox = new ComboBox<>();
        IntStream.rangeClosed(1, 12).forEach(monthComboBox.getItems()::add);

        // ComboBox para o ano
        ComboBox<Integer> yearComboBox = new ComboBox<>();
        IntStream.rangeClosed(1900, 2100).forEach(yearComboBox.getItems()::add);
        // Layout horizontal
        HBox hbox = new HBox(10, dayComboBox, monthComboBox, yearComboBox);

        Label nascimento = new Label("nascimento");
        Button Botao_confirma = new Button("confirmar");
        Botao_confirma.setOnAction(actionEvent -> {
            String fazlogin = TEXTO.getText();
            String Senhalogin = TEXTO2.getText();
            String cpfus = TEXTO4.getText();

            Integer dia = dayComboBox.getValue();
            Integer mes = monthComboBox.getValue();
            Integer ano = yearComboBox.getValue();

            if (fazlogin == null || fazlogin.isEmpty() || Senhalogin == null || Senhalogin.isEmpty() || cpfus == null || cpfus.isEmpty()) {
                System.out.println("Erro: Preencha todos os campos obrigatórios.");
                return;
            }


            if (dia != null && mes != null && ano != null) {
                try {
                    String formattedDate = String.format("%02d/%02d/%04d", dia, mes, ano);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    LocalDate dataNascimento = LocalDate.parse(formattedDate, formatter);

                    Cadastro_usuario login = new Cadastro_usuario();
                    login.cadastrarUsuario(fazlogin, Senhalogin, cpfus, dataNascimento);
                    System.out.println("Usuário cadastrado com sucesso!");
                } catch (DateTimeParseException e) {
                    System.out.println("Erro ao parsear a data: " + e.getMessage());
                }
            } else {
                System.out.println("Erro: Preencha todos os campos de data.");
            }
        });



        VBox box = new VBox();
        box.setSpacing(10);
        box.getChildren().addAll(
                Login, TEXTO,
                Senha, TEXTO2,
                nascimento,hbox,
                cpf, TEXTO4,
                Botao_confirma,
                botao_voltar
        );

        Scene cena = new Scene(box,400,400);
        cena.getStylesheets().add("Estilos.css");
        stage.setScene(cena);
        stage.show();
    }
}
