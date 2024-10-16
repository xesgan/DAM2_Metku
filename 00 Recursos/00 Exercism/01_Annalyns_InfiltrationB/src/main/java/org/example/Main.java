package org.example;

import java.util.Scanner;

class AnnalynsInfiltration {
    public static boolean canFastAttack(boolean knightIsAwake) {
        return !knightIsAwake;
    }

    public static boolean canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake) {
        return knightIsAwake || archerIsAwake || prisonerIsAwake;
    }

    public static boolean canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake) {
        // Simplificación de comparación booleana
        return !archerIsAwake && prisonerIsAwake;
    }

    public static boolean canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent) {
        // Lógica más simple para liberar prisionero
        return (!archerIsAwake && petDogIsPresent) || (!knightIsAwake && !archerIsAwake && prisonerIsAwake);
    }

    public static void main(String[] args) {
        System.out.println("Fast Attack: " + AnnalynsInfiltration.canFastAttack(true));
        System.out.println("Can Spy: " + AnnalynsInfiltration.canSpy(false, true, false));
        System.out.println("Signal Prisoner: " + AnnalynsInfiltration.canSignalPrisoner(false, true));
        System.out.println("Free Prisoner: " + AnnalynsInfiltration.canFreePrisoner(false, true, false, false));
    }
}
