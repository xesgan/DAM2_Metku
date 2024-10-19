package org.example;

import java.io.*;
import java.util.Scanner;

import static org.example.SustituirLletra.sustituirLetra;

public class CrearArchivoEncryptedPadre {
    public static void crearArchivoIndexHtml() throws IOException {
        File archivoEncrypted = new File("encrypted.txt");

        // Verificar si el archivo encrypted.txt existe
        if (!archivoEncrypted.exists()) {
            System.out.println("El archivo encrypted.txt no existe.");
            System.out.println("¿Deseas realizar la opción 3 (Sustitución de caracteres) para generarlo? (S/N)");
            Scanner sc = new Scanner(System.in);
            String respuesta = sc.nextLine().trim().toUpperCase();

            if (respuesta.equals("S")) {
                // Llamar a la opción 3 para realizar la sustitución
                sustituirLetra();  // Aqui reutilice el codigo por lo que tuve que separar en clases
            } else {
                System.out.println("Operación cancelada. No se puede continuar sin el archivo encrypted.txt.");
                return;
            }
        }

        // Llamar al proceso hijo para crear el archivo index.html
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp",
                    "../psp_u2_RoigAlconElias_recursos/out/artifacts/psp_u2_RoigAlconElias_recursos_jar/psp_u2_RoigAlconElias_recursos.jar",
                    "org.example.ReceptorHijo",  // Proceso hijo
                    "crearIndex");  // Comando para crear el archivo index.html

            pb.redirectErrorStream(true);
            Process process = pb.start();

            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()))) {
                writer.write(archivoEncrypted.getAbsolutePath());
                writer.newLine();
                writer.flush();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // Leer la salida del proceso hijo
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Mostrar el mensaje del proceso hijo
            // System.out.println("Resultado del proceso hijo:");
            System.out.println(content.toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}