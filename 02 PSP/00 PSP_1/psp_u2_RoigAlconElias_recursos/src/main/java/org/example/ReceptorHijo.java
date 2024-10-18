package org.example;

import java.io.IOException;

import static org.example.CarregarPaginaWebHijo.descargarHTML;
import static org.example.CarregarPaginaWebHijo.leerContenidoDesdeEntrada;
import static org.example.ContarCaracterHijo.contarCaracterOperacion;
import static org.example.SubstituirCaracterHijo.realizarSustitucion;

public class ReceptorHijo {
    public static String contenidoHTML = "";

    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length < 1) {
            System.out.println("Debe especificar un comando.");
            System.exit(1);
        }

        String comando = args[0];  // Comando recibido

        switch (comando) {
            case "cargar":
                String url = leerContenidoDesdeEntrada();
                System.out.println("===================================================================");
                System.out.println("URL recibida por el proceso padre: " + url);  // Mostrar la URL recibida

                String contenidoHTML = descargarHTML(url);

                if (contenidoHTML == null || contenidoHTML.isEmpty()) {
                    System.out.println("\nError: No se pudo descargar el contenido HTML o está vacío.");
                } else {
                    System.out.println("\nContenido HTML descargado correctamente:" + "\n");
                    System.out.println(contenidoHTML);
                }
                System.out.println("\n===================================================================");
                break;

            case "contar":
                if (args.length != 2) {
                    System.out.println("Debe ingresar un carácter para contar.");
                    System.exit(1);
                }
                contarCaracterOperacion();
                break;

            case "substituir":
                if (args.length != 3) {
                    System.out.println("Debe ingresar dos caracteres para la sustitución.");
                    System.exit(1);
                }
                String letraOriginal = args[1];
                String nuevaLetra = args[2];
                realizarSustitucion(letraOriginal, nuevaLetra);
                break;

            default:
                System.out.println("Comando desconocido: " + comando);
                System.out.println("Comandos disponibles: cargar, contar, substituir");
                System.exit(1);
        }
    }
}