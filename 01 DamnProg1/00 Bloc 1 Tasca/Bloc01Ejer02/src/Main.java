/**
 * Modifícalo para declarar e inicializar las cinco variables necesarias
 * para desglosar y guardar tu nombre y tus dos apellidos (nombre, primerApellido,
 * segundoApellido, nombreCompleto) y para guardar tu altura como un número real con dos decimales.
 *
 * @author Metku - Elias Roig DAM1
 */

public class Main {
    public static void main(String[] args) {
        String firstName = "Elias";
        String lastName = "Roig";
        String secondLastName = "Alcon";
        double altura = 1.71;
        String fullName = firstName + " " + lastName + " " + secondLastName + ", " + altura;
        System.out.println(fullName);
    }
}
