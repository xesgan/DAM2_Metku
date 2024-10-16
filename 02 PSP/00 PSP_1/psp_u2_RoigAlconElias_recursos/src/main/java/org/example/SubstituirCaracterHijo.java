package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.example.CarregarPaginaWebHijo.leerContenidoDesdeEntrada;

public class SubstituirCaracterHijo {
    public static void realizarSustitucion(char letraOriginal, char nuevaLetra) {
        // Leer el contenido HTML desde la entrada estandar
        String contenido = leerContenidoDesdeEntrada();

        if (contenido == null || contenido.isEmpty()) {
            System.out.println("No se ha encontrado el archivo contenido.html.");
            System.exit(1);
        }

        // Sustituir la letra original por la nueva
        String contenidoModificado = sustituirLetra(contenido, letraOriginal, nuevaLetra);

        // Escribir el contenido modificado en encrypted.txt
        escribirArchivo("encrypted.txt", contenidoModificado);

        // Enviar mensaje de éxito al proceso padre
        System.out.println("Arxiu creat amb èxit.");
    }

    public static String sustituirLetra(String texto, char letraOriginal, char nuevaLetra) {
        return texto.replace(letraOriginal, nuevaLetra);
    }

    private static void escribirArchivo(String archivo, String contenido) {
        try {
            Files.write(Paths.get(archivo), contenido.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
