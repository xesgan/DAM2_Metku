package org.example;

import java.io.*;

import static org.example.Programa.contenidoHTML;
import static org.example.Programa.sc;

public class AnalizarNombreCaracter {

    public static void analizarNombreCaracter() {
        System.out.println("\n-----------------------------------------------");
        System.out.println("Introduce el caracter que deseas contar: ");
        String input = sc.nextLine().trim();

        // Validar que el usuario haya escrito exactamente un caracter
        if (input.length() != 1) {
            System.out.println("\nEntrada invalida. Debe ser solo un caracter.");
            return;
        }

        char caracter = input.charAt(0);

        // Ejecutar el proceso hijo y obtener el resultado
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                    "org.example.ReceptorHijo",  // Clase del proceso hijo
                    "contar",  // Comando para que el proceso hijo sepa que debe contar el caracter
                    String.valueOf(caracter));  // Pasar el caracter al proceso hijo

            pb.redirectErrorStream(true); // Combina stdout y stderr

            Process process = pb.start();

            // Enviamos los datos al proceso hijo
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                writer.write(caracter);
                writer.newLine();
                writer.write(contenidoHTML.toString());
                writer.newLine();
                writer.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            process.waitFor();


            // Leer la salida del proceso hijo
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                StringBuilder resultado = new StringBuilder();
                while ((linea = reader.readLine()) != null) {
                    resultado.append(linea).append("\n");
                }

                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Número de veces que aparece " + caracter + " : " + resultado.toString().trim());
                    System.out.println("-----------------------------------------------\n");
                } else {
                    System.out.println("\nEl proceso hijo finalizó con errores.");
                    System.out.println(resultado);
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("\nError al ejecutar el proceso hijo.");
            e.printStackTrace();
        }
    }
}
