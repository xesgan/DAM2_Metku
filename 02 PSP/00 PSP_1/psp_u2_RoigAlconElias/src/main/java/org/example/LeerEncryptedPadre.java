package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerEncryptedPadre {
    public static void leerArchivo() {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                    "org.example.ReceptorHijo",
                    "leer");  // Comando "leer" para leer el archivo

            pb.redirectErrorStream(true);
            Process process = pb.start();

            // Leer la salida del proceso hijo
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    System.out.println(linea);
                }

                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.out.println("El proceso hijo finalizó con errores.");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
