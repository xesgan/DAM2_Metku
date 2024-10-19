package org.example;

import java.io.*;

import static org.example.Programa.contenidoHTML;
import static org.example.Programa.sc;

/**
 * Clase que gestiona la carga de una página web.
 * <p>
 * Esta clase proporciona funcionalidad para cargar el contenido de una página web
 * utilizando un proceso hijo. Las principales características incluyen:
 *  <ul>
 *    <li>Solicita al usuario que introduzca una URL</li>
 *    <li>Valida la URL introducida</li>
 *    <li>Crea un proceso hijo para cargar la página web</li>
 *    <li>Envía la URL al proceso hijo</li>
 *    <li>Lee la salida del proceso hijo (contenido HTML)</li>
 *    <li>Almacena el contenido HTML en una variable global</li>
 * </ul>
 * <p>
 * El método principal, carregarPaginaWeb(), maneja todo el proceso de carga,
 * incluyendo la interacción con el usuario y el manejo de errores.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class CarregarPaginaWeb {

    public static void carregarPaginaWeb() throws IOException, InterruptedException {

        System.out.println("\nIntroduce la URL de la página web (debe comenzar con http:// o https://):");
        System.out.println("Ejemplo: https://paucasesnovescifp.cat/");
        String urlWeb = sc.nextLine().trim();

        // Validar la URL
        if (!urlWeb.startsWith("http://") && !urlWeb.startsWith("https://")) {
            System.out.println("\n[[ URL inválida. Debe comenzar con http:// o https:// ]] \n");
            return; // Terminar el método si la URL es inválida
        } else {
            System.out.println("\n----- >>          URL Valida           << -----\n");
            System.out.println("----- >>  Espera un segundo por favor  << -----\n");
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
            writer.write(urlWeb);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leemos la salida del proceso hijo
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String linea;
            StringBuilder content = new StringBuilder();

            while ((linea = reader.readLine()) != null) {
                content.append(linea).append("\n");
            }

            // Almacenamos el contenido HTML en la variable global
            contenidoHTML = content.toString();
            /** // System.out.println("Salida proceso hijo: ");
             System.out.println(contenidoHTML); **/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}