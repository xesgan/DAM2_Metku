package org.example;

import java.io.*;

import static org.example.Programa.contenidoHTML;
import static org.example.Programa.sc;

/**
 * Clase que maneja la funcionalidad de sustitución de letras en un texto.
 *
 * Esta clase proporciona métodos para:
 * <ul>
 *   <li>Validar la entrada del usuario para la sustitución de letras</li>
 *   <li>Realizar la sustitución de letras en el texto</li>
 *   <li>Ejecutar un proceso hijo para llevar a cabo la sustitución</li>
 * </ul>
 *
 * La clase utiliza un proceso hijo para realizar la sustitución real,
 * comunicándose con él a través de entrada/salida estándar.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class SustituirLletra {

    public static void sustituirLetra() {
        String[] letras = validarSustitucion();
        if (letras != null) {
            realizarSustitucion(letras[0], letras[1]);
        }
    }

    public static String[] validarSustitucion() {
        System.out.println("\n===================================================================\n");
        System.out.println("Introduce la letra que deseas sustituir: ");
        String letraOriginal = sc.nextLine().trim();

        System.out.println("Introduce la nueva letra: ");
        String nuevaLetra = sc.nextLine().trim();
        System.out.println("\n===================================================================\n");

        // Validar que ambas entradas sean de un solo caracter
        if (letraOriginal.length() != 1 || nuevaLetra.length() != 1) {
            System.out.println("\n[[ Entrada invalida. Solo una letra por entrada. ]] \n");
            return null;
        }
        return new String[] {letraOriginal, nuevaLetra};
    }

    public static void realizarSustitucion(String letraOriginal, String nuevaLetra) {
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

            // Enviamos la entrada al proceso hijo
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                bw.write(letraOriginal);
                bw.newLine();
                bw.write(nuevaLetra);
                bw.newLine();
                bw.write("-"); // Delimitador
                bw.newLine();
                bw.write(contenidoHTML.toString());
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

            process.waitFor();

            // Leer la salida del proceso hijo
            try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String linea;
                StringBuilder resultado = new StringBuilder();
                while ((linea = br.readLine()) != null) {
                    resultado.append(linea).append("\n");
                }
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("---------------------------");
                    System.out.println(resultado.toString().trim());
                    System.out.println("---------------------------\n\n");
                } else {
                    System.out.println("\nEl proceso hijo finalizo con errores.");
                    System.out.println(resultado);
                }
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("\nError al ejecutar el proceso hijo.");
            e.printStackTrace();
        }
    }
}