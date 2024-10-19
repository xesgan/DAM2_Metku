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
<<<<<<< HEAD
            System.out.println("\n - - - > Contenido de " + archivo + " < - - - \n" + contenido);

        } catch (IOException e) {
            System.out.println("\nError al leer el archivo: " + archivo);
=======
            System.out.println("Contenido de " + archivo + ":");
            System.out.println(contenido);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
>>>>>>> f633b9ef417cfd1e258db11d199d96b63b52e2de
            e.printStackTrace();
        }
    }
}
