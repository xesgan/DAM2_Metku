package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReceptorHijo {

    public static String leerArchivo(String nombreArchivo){
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + nombreArchivo);
            e.printStackTrace();
            return null;
        }
        return contenido.toString();
    }

    public static int contarCaracter(String texto, char caracter){
        int contador = 0;
        for (char c : texto.toCharArray()) {
            if ( c == caracter ) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Debe ingresar un caracter como argumento.");
            System.exit(1);
        }

        String comando = args[0];

        switch (comando) {
            case "contar":
                if (args.length != 2) {
                    System.out.println("Debe ingresar un caracter para contar.");
                    System.exit(1);
                }
                char caracter = args[1].charAt(0);
                contarCaracterOperacion(caracter);
                break;
        }

        // Leer el contenido de 'contenido.html'
        String contenido = leerArchivo("contenido.html");
        if (contenido == null) {
            System.out.println("No se ha encontrado el archivo.");
            System.exit(1);
        }

        // Contar las ocurrencias del caracter
        int conteo = contarCaracter(contenido, caracter);

        // Devolver el resultado al proceso padre
        System.out.println(conteo);
    }
}