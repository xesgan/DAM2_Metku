package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SubstituirCaracterHijo {
    public static void realizarSustitucion(String letraOriginal, String nuevaLetra) {
        // Leer el contenido HTML desde la entrada estandar
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder contenido = new StringBuilder();
            String line;

            // Leer el contenido HTML desde la entrada estándar
            while ((line = br.readLine()) != null) {
                contenido.append(line).append("\n");
            }


            // Llamar al metodo para realizar la sustitucion
            String contenidoModificado =
                    sustituirLetra(contenido.toString(),
                                    letraOriginal.charAt(0), // Aqui se modifica el string a char
                                    nuevaLetra.charAt(0));

            // Escribir el contenido modificado en encrypted.txt
            escribirArchivo("encrypted.txt", contenidoModificado);

            // Enviar mensaje de éxito al proceso padre
            System.out.println("\nArxiu creat amb èxit.");
            System.out.println("Directorio de trabajo actual: " + System.getProperty("user.dir"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sustituirLetra(String texto, char letraOriginal, char nuevaLetra) {
        return texto.replace(letraOriginal, nuevaLetra);
        /** for (int i = 0; i < contenido.length(); i++) {
         if (contenido.charAt(i) == letraOriginal.charAt(0)) {
         contenido.setCharAt(i, nuevaLetra.charAt(0)); // aqui se sustituyen las letras
         }
         } **/
    }

    private static void escribirArchivo(String archivo, String contenido) {
        try {
            Files.write(Paths.get(archivo), contenido.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
