package org.example;

/**
 * Dado el siguiente código y sin ejecutarlo en Netbeans
 * haz el seguimiento del código, e indica:
 *
 * el valor de cada una de les variables al final del programa
 * la salida por pantalla del programa el significado de los
 * comentarios de las líneas de código 8 y 11
 *
 * @author Metku - Elias Roig
 */

public class Main {
    public static void main(String[] args) {

        int resultado = 10 + 500;

        int resultadoPrimero = resultado; // 510

        int resultadoSegundo = resultado + resultadoPrimero;

        System.out.println("segundo resultado = " + resultadoSegundo);

        int miEntero = 5;

        double miDoble = miEntero; // Automatic casting: int to double

        System.out.println(miDoble);

        miDoble = 7.68d;

        miEntero = (int) miDoble; // Manual casting: double to int

        System.out.println(miEntero);

    }
}