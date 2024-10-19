package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CrearIndexHtmlHijo {
    public static void crearIndexHtml() {
        String rutaArchivoEncrypted = "../psp_u2_RoigAlconElias/encrypted.txt";
        String rutaArchivoIndex = "index.html";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivoEncrypted))) {
            StringBuilder contenidoTxt = new StringBuilder();
            String linea;

            // Leer todo el archivo encrypted.txt
            while ((linea = br.readLine()) != null) {
                contenidoTxt.append(linea).append("\n");
            }

            // Extraer el contenido entre <body> y </body>
            String bodyContent = extraerContenidoBody(contenidoTxt.toString());

            if (bodyContent != null && !bodyContent.isEmpty()) {
                // Crear el archivo index.html usando BufferedWriter
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivoIndex))) {
                    bw.write("<html>\n<head><title>Index</title></head>\n<body>\n");
                    bw.write(bodyContent);
                    bw.write("\n</body>\n</html>");
                    System.out.println("\n=======================================\n");
                    System.out.println("Archivo index.html creado correctamente.");
                    System.out.println("\n=======================================\n");
                }
            } else {
                System.out.println("No se encontró contenido entre las etiquetas <body>.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer los archivos.");
            e.printStackTrace();
        }

    }

    // Método para extraer el contenido entre <body> y </body>
    public static String extraerContenidoBody(String contenidoTxt) {
        int inicioBody = contenidoTxt.indexOf("<body");
        int finBody = contenidoTxt.indexOf("</body>");

        if (inicioBody != -1 && finBody != -1) {
            // Encontrar el final de la etiqueta de apertura de <body> (por si tiene atributos)
            int cierreBody = contenidoTxt.indexOf(">", inicioBody);
            return contenidoTxt.substring(cierreBody + 1, finBody).trim();
        } else {
            return null; // No se encontraron las etiquetas
        }
    }
}
