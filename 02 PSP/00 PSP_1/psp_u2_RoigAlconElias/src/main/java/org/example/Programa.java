package org.example;

import java.io.*;
import java.util.Scanner;
import static org.example.AnalizarNombreCaracter.analizarNombreCaracter;
import static org.example.CarregarPaginaWeb.carregarPaginaWeb;
import static org.example.EjecutarIndexHtmlPadre.ejecutarIndexHtml;
import static org.example.LeerEncryptedPadre.leerArchivo;
import static org.example.BuscarPalabraclavePadre.buscarPalabraClave;
import static org.example.SustituirLletra.sustituirLetra;
import static org.example.CrearArchivoEncryptedPadre.crearArchivoIndexHtml;

/**
 * Clase principal que implementa un programa de menú interactivo para manejar páginas web y archivos.
 *
 * Esta clase proporciona las siguientes funcionalidades:
 * <ul>
 *   <li>Cargar una página web</li>
 *   <li>Analizar el número de caracteres en un texto</li>
 *   <li>Sustituir letras en un texto</li>
 *   <li>Leer un archivo encriptado</li>
 *   <li>Buscar palabras clave en un texto</li>
 *   <li>Crear un archivo index.html</li>
 *   <li>Ejecutar un archivo index.html</li>
 * </ul>
 *
 * El programa utiliza un bucle while para mostrar continuamente un menú de opciones al usuario,
 * y ejecuta la funcionalidad correspondiente basándose en la entrada del usuario.
 *
 * @author [xesgan - Elias Roig]
 * @version 1.0
 */

public class Programa {
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
                System.out.println("\n [[ Opcion invalida ]]\n");
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
                    System.out.println("\n - - [[ Saliendo del programa... ]] - -");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
