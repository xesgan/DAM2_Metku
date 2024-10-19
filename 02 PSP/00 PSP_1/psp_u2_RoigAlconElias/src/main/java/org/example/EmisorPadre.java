package org.example;

import java.io.*;
import java.util.Scanner;

import static org.example.AnalizarNombreCaracter.analizarNombreCaracter;
import static org.example.CarregarPaginaWeb.carregarPaginaWeb;
<<<<<<< HEAD:02 PSP/00 PSP_1/psp_u2_RoigAlconElias/src/main/java/org/example/EmisorPadre.java
import static org.example.EjecutarIndexHtmlPadre.ejecutarIndexHtml;
import static org.example.LeerEncryptedPadre.leerArchivo;
import static org.example.BuscarPalabraclavePadre.buscarPalabraClave;
import static org.example.SustituirLletra.sustituirLetra;
import static org.example.CrearArchivoEncryptedPadre.crearArchivoIndexHtml;
=======
import static org.example.LeerEncryptedPadre.leerArchivo;
import static org.example.SubstituirLletra.susbtituirLletra;
>>>>>>> f633b9ef417cfd1e258db11d199d96b63b52e2de:02 PSP/00 PSP_1/psp_u2_RoigAlconElias/src/main/java/org/example/emisorPadre.java

public class EmisorPadre {
    public static Scanner sc = new Scanner(System.in);
    public static String contenidoHTML = "";  // Variable global

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
                    carregarPaginaWeb();
                    break;
                case 2:
                    analizarNombreCaracter();
                    break;
                case 3:
                    sustituirLetra();
                    break;
                case 4:
                    leerArchivo();
                    break;
                case 5:
                    buscarPalabraClave();
                    break;
                case 6:
                    crearArchivoIndexHtml();
                    break;
                case 7:
                    ejecutarIndexHtml();
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
