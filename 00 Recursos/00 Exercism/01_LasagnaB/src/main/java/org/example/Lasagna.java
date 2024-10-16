package org.example;

public class Lasagna {

    int minutos = 1;
    int tiempoTotal = 40 * minutos;


    public static void main(String[] args) {


        // TODO: define the 'expectedMinutesInOven()' method
        Lasagna lasagna = new Lasagna();
        lasagna.expectedMinutesInOven();


        // TODO: define the 'remainingMinutesInOven()' method
        lasagna.remainingMinutesInOven(30);


        // TODO: define the 'preparationTimeInMinutes()' method
        lasagna.preparationTimeInMinutes(2);


        // TODO: define the 'totalTimeInMinutes()' method
        lasagna.totalTimeInMinutes(3, 20);
    }


    public int expectedMinutesInOven() {

        System.out.println("Tiempo total = " + tiempoTotal);
        return tiempoTotal;
    }


    public int remainingMinutesInOven(int tiempoMenor) {

        int tiempoRestante = tiempoTotal - tiempoMenor;
        System.out.println("Tiempo restante = " + tiempoRestante);
        return tiempoRestante;


    }


    public int preparationTimeInMinutes(int capas) {

        int minCapas = capas * 2;
        return minCapas;
    }


    public int totalTimeInMinutes(int capas, int tiempoEnHorno) {

        int totalTimeOven = (capas * 2) + tiempoEnHorno;
        return totalTimeOven;
    }
}