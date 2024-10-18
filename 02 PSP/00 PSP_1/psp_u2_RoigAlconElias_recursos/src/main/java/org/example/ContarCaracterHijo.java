package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.example.ReceptorHijo.contenidoHTML;

public class ContarCaracterHijo {

    // Contar ocurrencias del caracter en el texto dado
    /** public static int contarCaracter(String texto){
        int contador = 0;
        for (char c : texto.toCharArray()) {
            if ( c == caracter ) {
                contador++;
            }
        }
        return contador;
    } **/

    // Operacion que realiza la cuenta del caracter especificado
    public static void contarCaracterOperacion() throws IOException {
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

        /** if (contenidoHTML.isEmpty()) {
            System.out.println(contenidoHTML);
            System.out.println("Error: No se pudo descargar el contenido HTML o está vacío.");
        } else {
            // Contar el carácter en el contenido HTML
            int conteo = contarCaracter(contenidoHTML);
            System.out.println(conteo);  // Imprimir el resultado para que el padre lo capture
        } **/
    }
}
