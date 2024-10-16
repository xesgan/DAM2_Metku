package org.example;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class emisorPadre {
    static Scanner sc = new Scanner(System.in);
    static String contenidoHTML = "";


    public static void mostrarMenu() {
        System.out.println("1. Carregar pàgina Web");
        System.out.println("2. Analitzar el nombre de caràcters");
        System.out.println("3. Substituir lletra");
        System.out.println("4. Llegir encrypted.txt");
        System.out.println("5. Cercar paraules clau");
        System.out.println("6. Crear arxiu index.html");
        System.out.println("7. Ejecutar arxiu index.html");
        System.out.println("8. Sortir");
    }

    public static void carregarPaginaWeb() {
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
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al descargar el HTML");
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

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        try(FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(contenido);
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo " + nombreArchivo);
            e.printStackTrace();
        }
    }

    public static void analizarNombreCaracter() {
        System.out.println("Introduce el caracter que deseas contar: ");
        String input = sc.nextLine().trim();

        // Validar que el usuario haya escrito exactamente un caracter
        if(input.length() != 1) {
            System.out.println("Entrada invalida. Debe ser solo un caracter.");
            return;
        }

        char caracter = input.charAt(0);

        // Ejecutar el proceso hijo y obtener el resultado
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                    "org.example.ReceptorHijo",
                    "2",
                    String.valueOf(caracter));
            pb.redirectErrorStream(true); // Combina stdout y stderr

            Process process = pb.start();

            // Leer la salida del proceso hijo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            StringBuilder resultado = new StringBuilder();
            while ((linea = reader.readLine()) != null) {
                resultado.append(linea).append("\n");
            }

            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Numero de veces que aparece " + caracter + " : " + resultado.toString().trim());
            } else {
                System.out.println("El proceso hijo finalizo con errores.");
                System.out.println(resultado);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso hijo.");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            System.out.println("\nElige una opcion");
            int option;

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
                continue;
            }

            switch (option) {
                case 1:
                    carregarPaginaWeb();
                    break;
                case 2:
                    // Verificar si 'contenido.html' existe antes de analizar
                    File archivo = new File("contenido.html");
                    if (!archivo.exists()) {
                        System.out.println("El archivo no existe. Por favor, carga una página web primero (opción 1).");
                    } else {
                        analizarNombreCaracter();
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;
            }

        }
    }
}
