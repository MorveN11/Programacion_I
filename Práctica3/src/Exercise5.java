import java.util.Scanner;


public class Exercise5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int condition = 0;
        int number;
        System.out.println("Enter the number: ");
        number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                condition++;
            }
        }if (condition != 2) {
            System.out.println("The number isn't a prime number");
        }else {
            System.out.println("The number is a prime number");
        }

    }
}