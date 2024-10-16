package org.example;

import java.io.IOException;

import static org.example.CarregarPaginaWebHijo.leerContenidoDesdeEntrada;

public class ContarCaracterHijo {

    public static int contarCaracter(String texto, char caracter){
        int contador = 0;
        for (char c : texto.toCharArray()) {
            if ( c == caracter ) {
                contador++;
            }
        }
        return contador;
    }

    public static void contarCaracterOperacion(char caracter) {
        String contenidoHTML = leerContenidoDesdeEntrada();
        int conteo = contarCaracter(contenidoHTML, caracter);
        System.out.println(conteo);
    }
}
