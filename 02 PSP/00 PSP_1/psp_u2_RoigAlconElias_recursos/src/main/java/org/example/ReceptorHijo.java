package org.example;

import java.io.IOException;

import static org.example.CarregarPaginaWebHijo.leerContenidoDesdeEntrada;
import static org.example.ContarCaracterHijo.contarCaracterOperacion;
import static org.example.SubstituirCaracterHijo.realizarSustitucion;

public class ReceptorHijo {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Debe ingresar un caracter como argumento.");
            System.exit(1);
        }

        String comando = args[0];

        switch (comando) {
            case "cargar":
                String contenidoHTML = leerContenidoDesdeEntrada();
                System.out.println("Contenido HTML recibido: " + contenidoHTML);
                break;
            case "contar":
                if (args.length != 2) {
                    System.out.println("Debe ingresar un caracter para contar.");
                    System.exit(1);
                }
                char caracter = args[1].charAt(0);
                contarCaracterOperacion(caracter);
                break;
            case "substituir":
                if (args.length != 3) {
                    System.out.println("Debe ingresar dos caracteres para la sustitución.");
                    System.exit(1);
                }

                char letraOriginal = args[1].charAt(0);
                char nuevaLetra = args[2].charAt(0);
                realizarSustitucion(letraOriginal, nuevaLetra);
                break;
            default:
                System.out.println("Comando desconocido: " + comando);
                System.out.println("Comandos disponibles: contar");
                System.exit(1);
        }
    }
}