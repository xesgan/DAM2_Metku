package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Clase que maneja la ejecución de un archivo index.html.
 *
 * Esta clase proporciona funcionalidad para:
 * <ul>
 *   <li>Verificar la existencia de un archivo index.html</li>
 *   <li>Crear el archivo index.html si no existe</li>
 *   <li>Abrir el archivo index.html en el navegador predeterminado del sistema</li>
 * </ul>
 *
 * La clase utiliza la clase Desktop de Java para abrir el archivo en el navegador
 * y maneja las excepciones que puedan ocurrir durante este proceso.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class EjecutarIndexHtmlPadre {

    public static void ejecutarIndexHtml() {
        String rutaArchivoIndex = "index.html";

        // Verificar si el archivo index.html existe
        File archivoIndex = new File(rutaArchivoIndex);
        if (!archivoIndex.exists()) {
            // Si no existe, preguntar al usuario si desea crear el archivo
            System.out.println("El archivo index.html no existe. ¿Deseas crearlo ejecutando la opción 6? (s/n)");
            Scanner sc = new Scanner(System.in);
            String respuesta = sc.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                // Llamar al método que ejecuta la opción 6 para crear index.html
                CrearIndexHtmlHijo.crearIndexHtml();

                // Volver a intentar abrir el archivo después de crearlo
                if (archivoIndex.exists()) {
                    abrirArchivoEnNavegador(archivoIndex);
                } else {
                    System.out.println("\nError: No se pudo crear el archivo index.html.");
                }
            } else {
                System.out.println("\nOperación cancelada por el usuario.");
            }
        } else {
            // Si el archivo existe, lo abrimos en el navegador
            abrirArchivoEnNavegador(archivoIndex);
        }
    }

    // Método para abrir el archivo en el navegador
    private static void abrirArchivoEnNavegador(File archivo) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(archivo.toURI());  // Abre el archivo en el navegador
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Archivo " + archivo.getName() + " abierto en el navegador.");
                    System.out.println("-----------------------------------------------\n");
                } else {
                    System.out.println("\nError: No se puede abrir el navegador.");
                }
            } else {
                System.out.println("\nError: Desktop no soportado en este sistema.");
            }
        } catch (IOException e) {
            System.out.println("\nError al intentar abrir el archivo en el navegador.");
            e.printStackTrace();
        }
    }
}
