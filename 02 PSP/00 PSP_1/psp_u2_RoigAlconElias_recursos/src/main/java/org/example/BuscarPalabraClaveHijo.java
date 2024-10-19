package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que implementa la funcionalidad de buscar una palabra clave en un archivo.
 *
 * Esta clase proporciona las siguientes funcionalidades:
 * <ul>
 *   <li>Buscar una palabra clave en un archivo de texto</li>
 *   <li>Contar el número de ocurrencias de la palabra clave</li>
 *   <li>Mostrar el resultado de la búsqueda</li>
 * </ul>
 *
 * La clase utiliza un BufferedReader para leer el archivo línea por línea,
 * y un método auxiliar para contar las ocurrencias de la palabra clave en cada línea.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class BuscarPalabraClaveHijo {

    // Método que busca la palabra clave en el archivo
    public static void buscarPalabraClave(String archivo, String palabraClave) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int conteo = 0;
            StringBuilder contenido = new StringBuilder();

            // Leer línea por línea
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
                // Contar cuántas veces aparece la palabra clave en cada línea
                conteo += contarOcurrencias(linea, palabraClave);
            }

            // Mostrar el resultado
            System.out.println("\n[[ La palabra clave '" + palabraClave + "' aparece " + conteo + " veces en el archivo " + archivo + ". ]]");
            System.out.println("\n===================================================================\n");
        } catch (IOException e) {
            System.out.println("\nError al leer el archivo: " + archivo);
            e.printStackTrace();
        }
    }

    // Método auxiliar para contar ocurrencias de una palabra clave en una línea
    private static int contarOcurrencias(String linea, String palabraClave) {
        int index = 0, conteo = 0;
        while ((index = linea.indexOf(palabraClave, index)) != -1) {
            conteo++;
            index += palabraClave.length();  // Avanzar después de la palabra clave
        }
        return conteo;
    }
}