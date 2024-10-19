package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que crea un archivo index.html a partir del contenido de un archivo encrypted.txt.
 *
 * Esta clase proporciona las siguientes funcionalidades:
 * <ul>
 *   <li>Leer un archivo encrypted.txt</li>
 *   <li>Extraer el contenido del cuerpo (body) del archivo HTML</li>
 *   <li>Crear un nuevo archivo index.html con el contenido extraído</li>
 * </ul>
 *
 * La clase utiliza BufferedReader para leer el archivo de entrada y BufferedWriter
 * para escribir el nuevo archivo HTML. También incluye un método auxiliar para
 * extraer el contenido entre las etiquetas <body> del archivo de entrada.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

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
