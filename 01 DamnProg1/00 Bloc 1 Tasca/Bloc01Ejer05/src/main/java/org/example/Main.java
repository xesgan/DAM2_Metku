package org.example;

/**
 *Debes trabajar con todos los tipos de datos que no se han usado en el
 * ejercicio anterior.  Revisa la lista de tipos de datos primitivos en los
 * contenidos de la unidad 2.  Debes:
 *
 *     Declarar la variable cumpliendo los convenios y reglas para nombrar variables.
 *
 *     Inicializar la variable con los valores apropiados que consideres.
 *
 *     Mostrar en pantalla un mensaje con el valor de todas las variables.
 *
 * Entrega el código fuente escrito y una captura de pantalla para ver el
 * resultado de ejecutar este proyecto en tu Netbeans.
 */

public class Main {
    public static void main(String[] args) {
        byte edad = 25; // storage little numbers (8 bits)
        long distanciaTasca = 384400000L; // storage long number (64)
        float altura = 1.75f; // storage decimal simple numbers (32)
        double peso = 65.45; // storage for double-precision decimal numbers (64-bit)
        boolean soyMayorDeEdad = true; // storage a valor

        System.out.println(edad);
        System.out.println(distanciaTasca);
        System.out.println(altura);
        System.out.println(peso);
        System.out.println(soyMayorDeEdad);
    }
}