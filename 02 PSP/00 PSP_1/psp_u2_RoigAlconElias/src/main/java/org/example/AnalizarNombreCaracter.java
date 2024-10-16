package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.emisorPadre.sc;

public class AnalizarNombreCaracter {

    public static void analizarNombreCaracter() {
        System.out.println("Introduce el caracter que deseas contar: ");
        String input = sc.nextLine().trim();

        // Validar que el usuario haya escrito exactamente un caracter
        if(input.length() != 1) {
            System.out.println("Entrada invalida. Debe ser solo un caracter.");
            return;
        }

        char caracter = input.charAt(0);

        // Ejecutar el proceso hijo y obtener el resultado
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",  // CLASSPATH como el profesor lo quiere
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar", // ruta relativa de donde esta tu jar
                    "org.example.ReceptorHijo",  // este parametro es la clase donde quieres que vaya tu proceso
                    "contar",  // y este es un comando que anyadi para que el proceso supiera que tenia que activar gracias a un switch
                    String.valueOf(caracter));
            pb.redirectErrorStream(true); // Combina stdout y stderr

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
                System.out.println("Numero de veces que aparece " + caracter + " : " + resultado.toString().trim());
            } else {
                System.out.println("El proceso hijo finalizo con errores.");
                System.out.println(resultado);
            }

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar el proceso hijo.");
            e.printStackTrace();
        }
    }
}
