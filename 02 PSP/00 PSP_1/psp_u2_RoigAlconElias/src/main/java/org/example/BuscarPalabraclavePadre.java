package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static org.example.Programa.sc;

/**
 * Clase que implementa la funcionalidad de búsqueda de palabras clave en un archivo.
 *
 * Esta clase proporciona un método estático para buscar una palabra clave específica
 * en un archivo utilizando un proceso hijo. Las principales funcionalidades incluyen:
 * <ul>
 *   <li>Solicitar al usuario una palabra clave para buscar</li>
 *   <li>Validar la entrada del usuario</li>
 *   <li>Ejecutar un proceso hijo para realizar la búsqueda</li>
 *   <li>Mostrar los resultados de la búsqueda</li>
 * </ul>
 *
 * El método utiliza ProcessBuilder para crear y ejecutar un proceso hijo que realiza
 * la búsqueda real en el archivo.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class BuscarPalabraclavePadre {
    public static void buscarPalabraClave() {
        System.out.println("\n===================================================================\n");
        System.out.println("Introduce la palabra clave que deseas buscar en el archivo: \n");
        String palabraClave = sc.nextLine().trim();

        // Validar que sea una única palabra (sin espacios)
        if (palabraClave.isEmpty() || palabraClave.contains(" ")) {
            System.out.println("\n[[ Error: Debes introducir una única palabra sin espacios. ]]\n");
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
