package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que implementa la funcionalidad para leer un archivo encriptado.
 *
 * Esta clase proporciona un método estático para leer un archivo encriptado
 * utilizando un proceso hijo. Las funcionalidades incluyen:
 * <ul>
 *   <li>Ejecutar un proceso hijo para leer el archivo encriptado</li>
 *   <li>Capturar y mostrar la salida del proceso hijo</li>
 *   <li>Manejar errores de ejecución y finalización del proceso</li>
 * </ul>
 *
 * El método principal utiliza ProcessBuilder para ejecutar un programa Java externo
 * que se encarga de la lectura del archivo encriptado.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

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
                    System.out.println("\nEl proceso hijo finalizó con errores.");
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
