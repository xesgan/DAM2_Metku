package org.example;

import java.io.IOException;

import static org.example.BuscarPalabraClaveHijo.buscarPalabraClave;
import static org.example.CarregarPaginaWebHijo.descargarHTML;
import static org.example.CarregarPaginaWebHijo.leerContenidoDesdeEntrada;
import static org.example.ContarCaracterHijo.contarCaracterOperacion;
import static org.example.CrearIndexHtmlHijo.crearIndexHtml;
import static org.example.LeerEncryptedHijo.leerArchivoEncriptado;
import static org.example.SustituirCaracterHijo.realizarSustitucion;

public class ReceptorHijo {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Debe especificar un comando.");
            System.exit(1);
        }

        String comando = args[0];  // Comando recibido

        switch (comando) {
            case "cargar":
                String url = leerContenidoDesdeEntrada();


                String contenidoHTML = descargarHTML(url);

                if (contenidoHTML == null || contenidoHTML.isEmpty()) {
                    System.out.println("\nError: No se pudo descargar el contenido HTML o está vacío.");
                } else {
                    System.out.println(contenidoHTML);
                }
                // Este separador es solo para visualización en consola, no debería mezclarse con el archivo
                System.out.println("\n===================================================================");
                break;

            case "contar":
                if (args.length != 2) {
                    System.out.println("\nDebe ingresar un carácter para contar.");
                    System.exit(1);
                }
                contarCaracterOperacion();
                break;

            case "substituir":
                if (args.length != 3) {
                    System.out.println("\nDebe ingresar dos caracteres para la sustitución.");
                    System.exit(1);
                }
                String letraOriginal = args[1];
                String nuevaLetra = args[2];
                realizarSustitucion(letraOriginal, nuevaLetra);
                break;
            case "leer":
                String archivo = "encrypted.txt"; // Puedes cambiarlo si usas otro nombre de archivoPalabraClave
                leerArchivoEncriptado(archivo);
                break;
            case "buscar":
                if (args.length != 2) {
                    System.out.println("\nDebe ingresar una palabra clave para buscar.");
                    System.exit(1);
                }
                String palabraClave = args[1];  // Obtener la palabra clave desde los argumentos
                String archivoPalabraClave = "encrypted.txt";  // Archivo que vamos a buscar
                buscarPalabraClave(archivoPalabraClave, palabraClave);
                break;
            case "crearIndex":
                // Aquí llamamos al método que crea el archivo index.html
                crearIndexHtml();
                break;
            default:
                System.out.println("Comando desconocido: " + comando);
                System.out.println("Comandos disponibles: cargar, contar, substituir");
                System.exit(1);
        }
    }
}