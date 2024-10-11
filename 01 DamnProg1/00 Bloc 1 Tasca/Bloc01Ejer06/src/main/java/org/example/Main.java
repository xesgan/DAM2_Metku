package org.example;

import java.util.Scanner;

/**
 *  Crea un proyecto Maven en Netbeans denominado Bloc01Ejer06,
 *  para implementar el ejercicio 13 (Write a Java program to print the area
 *  and perimeter of a rectangle) de https://www.w3resource.com/java-exercises/basic/index.php
 *
 * modificándolo para pedir los datos por teclado usando la clase Scanner tal y
 * como se muestra en la solución del ejercicio anterior (ejercicio 12) y en el
 * apartado 5.4 de la Unidad de trabajo 2.
 *
 * Entrega el código fuente escrito y una captura de pantalla para ver el resultado
 * de ejecutar este proyecto en tu Netbeans.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce rectangle width: ");
        double width = sc.nextDouble();

        System.out.println("Introduce rectangle height: ");
        double height = sc.nextDouble();

        double perimeter = 2 * width + 2 * height;

        System.out.println("This is the rectangle area: ");
        double area = width * height;
        System.out.println(area);

        // Print the calculated perimeter using placeholders for values
        System.out.printf("Perimeter is 2*(%.1f + %.1f) = %.2f \n", height, width, perimeter);

        // Print the calculated area using placeholders for values
        System.out.printf("Area is %.1f * %.1f = %.2f \n", width, height, area);
    }
}