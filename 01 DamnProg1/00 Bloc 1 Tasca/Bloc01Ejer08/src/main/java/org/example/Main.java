package org.example;

import java.util.Scanner;

/**
 * Pida por teclado un número de segundos, muestre en pantalla cuántos días,
 * horas, minutos y segundos equivalen en el formato horario habitual.
 * Por ejemplo, debe mostrar para 10000 segundos introducidos por teclado:
 *
 * Output:
 *
 * 10000 segundos equivalen a:
 *
 * 0 días
 *
 * 2 horas
 *
 * 46 minutos
 *
 * 40 segundos
 *
 * No se pueden usar métodos proporcionados por las librerías de Java,
 * los cálculos deben realizarse únicamente con los operadores aritméticos
 * explicados en la unidad.  Para pedir los datos por teclado usar la clase
 * Scanner igual que en el ejercicio anterior.
 *
 * @author xesgan - Elias Roig
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce the seconds to convert: ");
        int seconds = sc.nextInt();

        int days = seconds / (24 * 3600);
        seconds %= 24 * 3600; // to rescue the seconds left after calculating the days

        int hours = seconds / 3600;
        seconds %= 3600;

        int minutes = seconds / 60;
        seconds %= 60;

        System.out.println("Output: \n" + days + "\n" + hours + "\n" + minutes + "\n" + seconds);
    }
}