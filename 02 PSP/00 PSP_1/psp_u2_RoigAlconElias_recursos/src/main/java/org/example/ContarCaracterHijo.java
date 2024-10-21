package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Clase que implementa la funcionalidad de contar caracteres en un texto HTML.
 *
 * Esta clase proporciona las siguientes funcionalidades:
 * <ul>
 *   <li>Leer un carácter y un delimitador desde la entrada estándar</li>
 *   <li>Leer un contenido HTML desde la entrada estándar</li>
 *   <li>Contar las ocurrencias de un carácter específico en el contenido HTML</li>
 *   <li>Imprimir el resultado del conteo</li>
 * </ul>
 *
 * La clase utiliza un BufferedReader para leer la entrada estándar y un StringBuilder
 * para construir el contenido HTML. El conteo se realiza carácter por carácter en el
 * contenido HTML.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class ContarCaracterHijo {

    // Operacion que realiza la cuenta del caracter especificado
    public static void contarCaracterOperacion() {
        // Leer contenido HTML desde la entrada estándar
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String caracter = br.readLine();
            // Leer el contenido HTML
            StringBuilder letraHTML = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                letraHTML.append(linea).append("\n");
            }

            // Contar veces que aparece el caracter en el html
            String html = letraHTML.toString(); // Se convierte a String para contar
            int conteo = 0;
            char charToCount = caracter.charAt(0);

            for (char c : html.toCharArray()) {
                if ( c == charToCount ) {
                    conteo++;
                }
            }

            // Devolvemos el resultado al proceso padre
            System.out.println(conteo);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
