package org.example;

import java.io.*;

import static org.example.emisorPadre.contenidoHTML;
import static org.example.emisorPadre.sc;

public class AnalizarNombreCaracter {

    public static void analizarNombreCaracter() {
        System.out.println("Introduce el caracter que deseas contar: ");
        String input = sc.nextLine().trim();

        // Validar que el usuario haya escrito exactamente un caracter
        if (input.length() != 1) {
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
                    "org.example.ReceptorHijo",  // Clase del proceso hijo
                    "contar",  // Comando para que el proceso hijo sepa que debe contar el caracter
                    String.valueOf(caracter));  // Pasar el caracter al proceso hijo

            pb.redirectErrorStream(true); // Combina stdout y stderr

            Process process = pb.start();

            // Enviar el HTML al proceso hijo a través de la entrada estándar
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                writer.write(contenidoHTML.toString());  // Enviar el HTML al hijo
                writer.newLine();
                writer.flush();
            }

            // Leer la salida del proceso hijo
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                StringBuilder resultado = new StringBuilder();
                while ((linea = reader.readLine()) != null) {
                    resultado.append(linea).append("\n");
                }

                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("Número de veces que aparece " + caracter + " : " + resultado.toString().trim() + "\n\n\n");
                } else {
                    System.out.println("El proceso hijo finalizó con errores.");
                    System.out.println(resultado);
                }
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso hijo.");
            e.printStackTrace();
        }
    }
}
