/**
 * Declara una variable para almacenar cada uno de los siguientes valores.
 * Trata de utilizar el tipo de datos que más se ajuste a los datos.
 * Justifica tu elección con un comentario en el propio código.
 * NO debes usar ningún método, debes realizar la inicialización con un literal.
 * Los nombres de la variables deben cumplir los convenios y reglas para nombrar variables.
 *
 *     Valor mínimo no modificable, constante: 34.
 *
 *     Una día de la semana como cadena de caracteres, por ejemplo “martes”.
 *
 *     La segunda letra de tu primer apellido.
 *
 *     Un salario en euros.
 *
 *     El número de seguidores de un influencer.
 *
 * Inicializa cada variable con un literal.
 *
 * Muestra en pantalla el valor contenido en cada una de las variables de forma que
 * cada valor aparezca en una línea distinta utilizando la orden println.
 *
 * @author xesgan - Elias Roig
 */

public class Main {
    public static void main(String[] args) {
        final int valorMinimo = 34;
        String diaSemana = "martes";
        char segundaLetraApellido = 'o';
        short salary = 2500;
        int numSeguidoresInfluencer = 160000;

        System.out.println(valorMinimo);
        System.out.println(diaSemana);
        System.out.println(segundaLetraApellido);
        System.out.println(salary);
        System.out.println(numSeguidoresInfluencer);
    }
}