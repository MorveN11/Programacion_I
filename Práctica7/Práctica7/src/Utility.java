import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {
    static int verifyNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean condition;
        int number = 0;
        do {
            try {
                number = scanner.nextInt();
                condition = true;
            } catch (InputMismatchException ime){
                System.out.println("Warning! only numbers are allowed");
                scanner.next();
                condition = false;
            }
        } while (!condition);
        return number;
    }

    static void printMatrix(int size, int[][] matrix) {
        System.out.println("\nThe matrix is: ");
        for(int i=0; i<size; i++) {
            System.out.print((i)+". ");
            for(int j=0; j<size; j++) {
                System.out.print("("+matrix[i][j]+")");
            }
            System.out.println();
        }
    }

    static void printMagicBox(int size, int[][] matrix) {
        System.out.println("\nThe magic box is: ");
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                System.out.print("("+matrix[i][j]+")");
            }
            System.out.println();
        }
    }

    static void printGame(int size, char[][] matrix) {
        System.out.println("\n*****************");
        System.out.println("\t---Game---");
        for(int i=0; i<size; i++) {
            System.out.print((i+1)+". ");
            for(int j=0; j<size; j++) {
                System.out.print("("+matrix[i][j]+")");
            }
            System.out.println();
        }
        System.out.println("*****************");
    }
}
