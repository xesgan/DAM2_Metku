package org.example;

import java.io.IOException;

import static org.example.CarregarPaginaWebHijo.leerContenidoDesdeEntrada;

public class ContarCaracterHijo {

    // Contar ocurrencias del caracter en el texto dado
    public static int contarCaracter(String texto, char caracter){
        int contador = 0;
        for (char c : texto.toCharArray()) {
            if ( c == caracter ) {
                contador++;
            }
        }
        return contador;
    }

    // Operacion que realiza la cuenta del caracter especificado
    public static void contarCaracterOperacion(char caracter) {
        String contenidoHTML = leerContenidoDesdeEntrada();  // Leer contenido HTML desde la entrada estándar
        int conteo = contarCaracter(contenidoHTML, caracter);  // Contar el carácter
        System.out.println(conteo);  // Imprimir el resultado para que el padre lo capture
    }
}
