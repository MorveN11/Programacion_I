import java.util.Scanner;


public class Exercise2 {

    public static void main(String[] args) {
        System.out.println("How many numbers do you want to compare?");
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        System.out.println("Enter the numbers");
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[n];

        for(int i = 0; i < numbers.length ; i ++) {
            System.out.println("Enter the number["+i+"]:");
            numbers[i] = scanner.nextInt();
        }
        int max = numbers[0];

        for(int i = 1; i < numbers.length; i ++) {
            if(max < numbers[i]){
                max = numbers[i];
            }
        }

        System.out.println("The max numbers is: " + max);

    }
}
