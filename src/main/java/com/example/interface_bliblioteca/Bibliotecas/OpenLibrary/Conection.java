package com.example.interface_bliblioteca.Bibliotecas.OpenLibrary;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Conection {
    public static void main(String[] args) {
        try {
            // URL da API e termo de busca
            String baseUrl = "https://openlibrary.org/search.json";
            String query = "Harry Potter";
            URL url = new URL(baseUrl + "?q=" + query.replace(" ", "+"));

            // Configurar conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Java-OpenLibraryAPI/1.0");

            // Verificar a resposta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Processar JSON
                Gson gson = new Gson();
                JsonObject jsonResponse = gson.fromJson(response.toString(), JsonObject.class);
                JsonArray books = jsonResponse.getAsJsonArray("docs");

                // Exibir títulos e autores
                System.out.println("Resultados da busca:");
                for (int i = 0; i < Math.min(5, books.size()); i++) {
                    JsonObject book = books.get(i).getAsJsonObject();
                    String title = book.get("title").getAsString();
                    String author = book.has("author_name") ? book.get("author_name").getAsJsonArray().get(0).getAsString() : "Autor desconhecido";
                    System.out.printf("Título: %s, Autor: %s%n", title, author);
                }
            } else {
                System.out.println("Erro na conexão. Código de resposta: " + responseCode);
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}