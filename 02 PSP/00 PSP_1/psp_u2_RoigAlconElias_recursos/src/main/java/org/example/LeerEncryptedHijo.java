package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que proporciona funcionalidad para leer archivos encriptados.
 *
 * Esta clase ofrece un método estático para leer y mostrar el contenido
 * de un archivo encriptado. Las principales funcionalidades son:
 * <ul>
 *   <li>Leer un archivo encriptado</li>
 *   <li>Mostrar el contenido del archivo en la consola</li>
 *   <li>Manejar errores de lectura de archivos</li>
 * </ul>
 *
 * El método principal de esta clase lee el archivo línea por línea,
 * acumula el contenido en un StringBuilder y luego lo muestra en la consola.
 * También incluye manejo de excepciones para tratar errores de entrada/salida.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class LeerEncryptedHijo {
    public static void leerArchivoEncriptado(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            StringBuilder contenido = new StringBuilder();

            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

            // Mostrar el contenido del archivo en la consola
            System.out.println("\n - - - > Contenido de " + archivo + " < - - - \n" + contenido);

            System.out.println("\nError al leer el archivo: " + archivo);
            System.out.println("Contenido de " + archivo + ":");
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
            e.printStackTrace();
        }
    }
}
