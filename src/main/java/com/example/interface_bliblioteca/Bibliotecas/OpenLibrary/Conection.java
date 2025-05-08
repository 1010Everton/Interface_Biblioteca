package com.example.interface_bliblioteca.Bibliotecas.OpenLibrary;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Conection {
    public String buscarLivros(String titulo) {
        StringBuilder resultadoFinal = new StringBuilder();

        try {
            String baseUrl = "https://openlibrary.org/search.json";
            URL url = new URL(baseUrl + "?q=" + titulo.replace(" ", "+"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Java-OpenLibraryAPI/1.0");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
                JsonArray books = jsonResponse.getAsJsonArray("docs");

                for (int i = 0; i < Math.min(5, books.size()); i++) {
                    JsonObject book = books.get(i).getAsJsonObject();
                    String title = book.get("title").getAsString();
                    String author = book.has("author_name")
                            ? book.get("author_name").getAsJsonArray().get(0).getAsString()
                            : "Autor desconhecido";
                    resultadoFinal.append("Título: ").append(title).append(", Autor: ").append(author).append("\n");
                }
            } else {
                resultadoFinal.append("Erro na conexão. Código: ").append(responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            resultadoFinal.append("Erro: ").append(e.getMessage());
        }

        return resultadoFinal.toString();
    }
}