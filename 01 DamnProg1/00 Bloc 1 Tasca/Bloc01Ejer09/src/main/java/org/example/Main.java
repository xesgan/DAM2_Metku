package org.example;

import java.util.Scanner;

/**
 * Pida por teclado el precio de una unidad de un producto (número real) y las
 * unidades que se desean comprar de dicho producto (número entero).
 *
 * El programa calculará y mostrará por pantalla utilizando la salida con formato
 * numérico con dos decimales (ejemplo 2954,32):
 *
 *     El total a pagar por las unidades de producto indicadas sin rebajas.
 *
 *     El nuevo precio de la unidad de producto si se le aplica un 5% de rebajas.
 *
 *     El total a pagar por las unidades de producto indicadas si se aplica el nuevo precio de rebajas.
 *
 * Puedes consultar la salida con formato printf https://xperti.io/blogs/formatting-with-printf-in-java/
 *
 * Entrega el código fuente escrito y una captura de pantalla para ver el resultado de
 * ejecutar este proyecto en tu Netbeans.
 *
 * @author Metku - Elias Roig
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce the product price: ");
        double price = sc.nextDouble();

        System.out.println("\nAmount: ");
        double amount = sc.nextDouble();

        double discount = 0.05;
        double unityFinalPrice = price * (1 * discount);
        double finalPrice = price - unityFinalPrice;

        System.out.printf("\nTotal is: $%.2f ", price * amount);
        System.out.printf("Discount to apply: %.0f%%%n", discount * 100); // %.0f%% shows the % to apply %n opens a new line
        System.out.printf("Product Discount applied price: $%.2f%n", finalPrice);
        System.out.printf("\nTotal Discount Price: $%.2f%n", finalPrice * amount);
    }
}