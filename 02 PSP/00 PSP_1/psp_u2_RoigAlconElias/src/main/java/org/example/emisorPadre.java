package org.example;

import java.io.*;
import java.util.Scanner;

import static org.example.AnalizarNombreCaracter.analizarNombreCaracter;
import static org.example.CarregarPaginaWeb.carregarPaginaWeb;
import static org.example.SubstituirLletra.susbtituirLletra;


public class emisorPadre {
    public static Scanner sc = new Scanner(System.in);
    public static String contenidoHTML = "";


    public static void mostrarMenu() {
        System.out.println("1. Carregar pàgina Web");
        System.out.println("2. Analitzar el nombre de caràcters");
        System.out.println("3. Substituir lletra");
        System.out.println("4. Llegir encrypted.txt");
        System.out.println("5. Cercar paraules clau");
        System.out.println("6. Crear arxiu index.html");
        System.out.println("7. Ejecutar arxiu index.html");
        System.out.println("8. Sortir");
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
                    carregarPaginaWeb();
                    break;
                case 2:
                    if (contenidoHTML.isEmpty()) {
                        System.out.println("No hay contenido HTML disponible. Por favor, carga una página web primero (opción 1).");
                    }
                    analizarNombreCaracter();
                    break;
                case 3:
                    susbtituirLletra();
                    break;
                case 4:
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
