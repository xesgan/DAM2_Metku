package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CarregarPaginaWebHijo{

    public static String leerContenidoDesdeEntrada() {

        StringBuilder url = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea = br.readLine();
            url.append(linea);  // Leer la URL pasada
        } catch (IOException e) {
            System.out.println("Error al leer la URL: " + e.getMessage());
        }
        return url.toString();
    }

    public static String descargarHTML(String url) {
        HttpClient client = HttpClient.newHttpClient(); // Java 11
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Comprobar si el código de estado es 200 (OK)
            if (response.statusCode() == 200) {
                return response.body();  // Devolver el HTML descargado
            } else {
                System.out.println("Error: Código de estado HTTP " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al descargar el HTML: " + e.getMessage());
        }
        return "";  // Retornar vacío si hubo un error
    }
}
