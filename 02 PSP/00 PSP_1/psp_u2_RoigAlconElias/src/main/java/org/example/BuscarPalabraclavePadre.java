package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.Programa.sc;

public class BuscarPalabraclavePadre {
    public static void buscarPalabraClave() {
        System.out.println("\n===================================================================\n");
        System.out.println("Introduce la palabra clave que deseas buscar en el archivo: \n");
        String palabraClave = sc.nextLine().trim();

        // Validar que sea una única palabra (sin espacios)
        if (palabraClave.isEmpty() || palabraClave.contains(" ")) {
            System.out.println("\nError: Debes introducir una única palabra sin espacios.");
            return;
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                    "org.example.ReceptorHijo",
                    "buscar",  // Comando "buscar" para buscar una palabra clave
                    palabraClave);  // Pasar la palabra clave

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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
