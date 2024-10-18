package org.example;

import java.io.*;
import java.util.Scanner;

import static org.example.AnalizarNombreCaracter.analizarNombreCaracter;
import static org.example.CarregarPaginaWeb.carregarPaginaWeb;
import static org.example.LeerEncryptedPadre.leerArchivo;
import static org.example.SubstituirLletra.susbtituirLletra;

public class emisorPadre {
    public static Scanner sc = new Scanner(System.in);
    public static String contenidoHTML = "";

    public static void mostrarMenu() {
        System.out.println(
                "=== MENU ===\n" +
                "1. Carregar pàgina Web\n" +
                "2. Analitzar el nombre de caràcters\n" +
                "3. Substituir lletra\n" +
                "4. Llegir encrypted.txt\n" +
                "5. Cercar paraules clau\n" +
                "6. Crear arxiu index.html\n" +
                "7. Ejecutar arxiu index.html\n" +
                "8. Sortir");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        while (true) {
            mostrarMenu();
            System.out.println("\nElige una opcion");
            int option;

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida");
                continue;
            }

            switch (option) {
                case 1:
                    carregarPaginaWeb(); // Llamamos a cargar página web
                    break;
                case 2:
                    analizarNombreCaracter();
                    break;
                case 3:
                    susbtituirLletra();
                    break;
                case 4:
                    leerArchivo();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    break;
            }
        }
    }
}
