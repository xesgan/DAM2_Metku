package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.emisorPadre.sc;

public class SubstituirLletra {

    public static void susbtituirLletra() {
        System.out.println("Introduce la letra que deseas sustituir: ");
        String letraOriginal = sc.nextLine().trim();

        System.out.println("Introduce la nueva letra: ");
        String nuevaLetra = sc.nextLine().trim();

        // Validar que ambas entradas sean de un solo caracter
        if (letraOriginal.length() != 1 || nuevaLetra.length() != 1) {
            System.out.println("Entrada invalida. Solo una letra por entrada.");
            return;
        }

        // Ejecutar el proceso hijo
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                    "org.example.ReceptorHijo",
                    "substituir",
                    letraOriginal,
                    nuevaLetra
            );

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
                System.out.println("Mensaje del proceso hijo: " + resultado.toString().trim());
            } else {
                System.out.println("El proceso hijo finalizo con errores.");
                System.out.println(resultado.toString());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso hijo.");
            e.printStackTrace();
        }
    }
}