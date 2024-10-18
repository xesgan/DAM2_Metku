package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerEncryptedHijo {
    public static void leerArchivoEncriptado(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            StringBuilder contenido = new StringBuilder();

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            // Mostrar el contenido del archivo en la consola
            System.out.println("Contenido de " + archivo + ":");
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
    }
}
