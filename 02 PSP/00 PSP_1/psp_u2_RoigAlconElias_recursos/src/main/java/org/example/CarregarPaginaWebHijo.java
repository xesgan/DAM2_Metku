package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Clase que implementa funcionalidades para cargar y procesar páginas web.
 *
 * Esta clase proporciona las siguientes funcionalidades:
 * <ul>
 *   <li>Leer una URL desde la entrada estándar</li>
 *   <li>Descargar el contenido HTML de una página web</li>
 * </ul>
 *
 * La clase utiliza HttpClient para realizar solicitudes HTTP y manejar las respuestas.
 *
 * En el método descargarHTML, se utiliza el código de estado HTTP 200 para verificar
 * si la solicitud fue exitosa. El código 200 indica que la solicitud fue recibida,
 * entendida y aceptada correctamente por el servidor. Solo si se recibe este código,
 * se procede a devolver el contenido HTML de la página.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

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
