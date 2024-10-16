package org.example;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.example.emisorPadre.contenidoHTML;
import static org.example.emisorPadre.sc;

public class CarregarPaginaWeb {

    public static void carregarPaginaWeb() throws IOException, InterruptedException {
        System.out.println("Introduce la URL de la página web (debe comenzar con http:// o https://):");
        String urlWeb = sc.nextLine().trim();

        // Validar la URL
        if (!urlWeb.startsWith("http://") && !urlWeb.startsWith("https://")) {
            System.out.println("URL inválida. Debe comenzar con http:// o https://");
            return; // Terminar el método si la URL es inválida
        } else {
            System.out.println("URL Valida.\n");
        }

        // Descargar el contenido HTML
        try {
            contenidoHTML = descargarHTML(urlWeb);
            System.out.println("Contenido HTML descargado: ");
            System.out.println(contenidoHTML);  // Mostrar el contenido HTML

            // El contenido HTML esta ya en una variable contenidoHTML

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al descargar el HTML");
            e.printStackTrace();
        }

        // Creamos el proceso hijo
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",
                "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                "org.example.ReceptorHijo",
                "cargar");
        Process process = pb.start();

        // Enviamos los datos al proceso hijo
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
            writer.write(contenidoHTML);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        process.waitFor();

        // Leemos la salida del proceso hijo
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String linea;
            StringBuilder content = new StringBuilder();

            while ((linea = reader.readLine()) != null) {
                content.append(linea).append("\n");
            }
            process.waitFor();

            // Almacenamos el contenido HTML en la variable global
            contenidoHTML = content.toString();
            System.out.println("Salida proceso hijo: ");
            System.out.println(contenidoHTML);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String descargarHTML(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient(); // Java 11
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
