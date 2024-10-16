package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarregarPaginaWebHijo{

    public static String leerContenidoDesdeEntrada() {
        StringBuilder contenidoHTML = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;
            // Leer el contenido HTML hasta que no haya más líneas
            while ((linea = br.readLine()) != null) {
                contenidoHTML.append(linea).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenidoHTML.toString();
    }
}
