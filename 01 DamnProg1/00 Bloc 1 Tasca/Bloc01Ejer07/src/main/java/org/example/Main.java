package org.example;

import java.util.Scanner;

/**
 *  Crea un proyecto Maven en Netbeans denominado Bloc01Ejer07 para
 *  convertir a grados Fahrenheit una temperatura introducida por
 *  teclado en grados Celsius.
 *
 * Entrega el código fuente escrito y una captura de pantalla para ver
 * el resultado de ejecutar este proyecto en tu Netbeans.
 *
 * @author xesgan - Elias Roig
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature to convert: ");
        double temperature = sc.nextDouble();

        System.out.println("-- [ Formula used: (°F - 32) * 5/9 = °C ] -- \n");
        System.out.println("-- -- Temperature conversion -- --");
        System.out.println("Fahrenheit to Celsius = " + ((temperature - 32) * 5 / 9));
    }
}