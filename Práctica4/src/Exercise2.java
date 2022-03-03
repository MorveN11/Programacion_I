import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[100];
        int[] generate = new int[numbers.length];
        int number, limit;

        do {
            System.out.println("Define the range of the numbers ¡more than "+(numbers.length-1)+"!");   //insertamos el limite de los numeros
            limit = scanner.nextInt();
        } while (limit < 100);

        System.out.println("Generate the first list...");
        for (int i = 0; i < numbers.length; i++) {                  //Generamos los numeros
            number = (int) (Math.random() * limit++);
            for (int k = 0; k < numbers.length; k++) {
                if (number == numbers[k]) {                         //Verificamos si existen repetidos
                    number = (int) (Math.random() * limit++);
                    k = -1;
                }
            }
            numbers[i] = number;                                    //añadimos los que son mayores a 25 y son pares
            if (number > 25 && (number % 2) == 0) {
                generate[i] = number;
            }
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println("Analyzing the numbers greater than 25 and even.... ");
        System.out.println("Complete, the second list is:");

        for (int j = 0; j < numbers.length; j++){                     //Imprimimos la segunda lista
            if (generate[j] != 0){
                System.out.print(generate[j] +","+ " ");
            }
        }
    }
}

