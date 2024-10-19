package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContarCaracterHijo {

    // Operacion que realiza la cuenta del caracter especificado
    public static void contarCaracterOperacion() throws IOException {
        // Leer contenido HTML desde la entrada estándar
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String caracter = br.readLine();
            String delimitador = br.readLine();

            // Leer el contenido HTML
            StringBuilder letraHTML = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.equals(delimitador)) { // Comprobamos el delimitador
                    break; // Salimos del bucle si encontramos el delimitador
                }
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
