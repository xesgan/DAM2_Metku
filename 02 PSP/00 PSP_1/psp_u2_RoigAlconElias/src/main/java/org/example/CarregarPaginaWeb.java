package org.example;

import java.io.*;


import static org.example.emisorPadre.contenidoHTML;
import static org.example.emisorPadre.sc;

public class CarregarPaginaWeb {

    public static void carregarPaginaWeb() throws IOException, InterruptedException {

        System.out.println("Introduce la URL de la página web (debe comenzar con http:// o https://):");
        System.out.println("Ejemplo: https://paucasesnovescifp.cat/");
        String urlWeb = sc.nextLine().trim();

        // Validar la URL
        if (!urlWeb.startsWith("http://") && !urlWeb.startsWith("https://")) {
            System.out.println("URL inválida. Debe comenzar con http:// o https://");
            return; // Terminar el método si la URL es inválida
        } else {
            System.out.println("----- >> URL Valida << -----\n");
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