import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[100];
        int random, limit;
        boolean status = true;

        do {
            System.out.println("Define the range of the numbers ¡more than"+(numbers.length-1)+"!");       //insertamos el limite de los numeros
            limit = scanner.nextInt();
        } while (limit < 100);

        System.out.println("Generate numbers...");
        for (int i = 0; i < numbers.length; i++) {              //Generamos los numeros 100 numeros
            random = (int) (Math.random() * limit++);
            for (int k = 0; k < numbers.length; k++) {
                if (random == numbers[k]) {                     //verificamos si no existen repetidos
                    random = (int) (Math.random() * limit++);
                    k = -1;
                }
            }
            numbers[i] = random;
        }

        System.out.println(Arrays.toString(numbers));
    }
}
