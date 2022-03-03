import java.io.IOException;
import java.util.Scanner;


public class Exercise3 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String text;
        char character;
        int times;
        text = scanner.nextLine();
        text = text.toLowerCase();
        System.out.print("Enter the character: ");
        character = (char) System.in.read();
        times = count_character(text, character);
        System.out.println("The character " + character + " appears " + (times) + " times");

    }

    public static int count_character(String text, char character) {

        int pos, count = 0;
        pos = text.indexOf(character);

        while (pos != -1) {
            count++;
            pos = text.indexOf(character, pos + 1);
        }
        return count;
    }

}
