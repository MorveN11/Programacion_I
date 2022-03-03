import java.io.IOException;
import java.util.Scanner;

public class MyLibrary {
    public MyLibrary() {
}
    public int Multiply(int a, int b) {
        return (a*b);
    }

    public int GetBiggest(int a, int b, int c, int d, int e, int f, int... numbers) {

        int max = numbers[0];
        for(int i = 1; i < numbers.length; i ++) {
            if(max < numbers[i]){
                max = numbers[i];
            }
        }
        return max;
    }

    public void Repeated(String text) throws IOException {
        char character;
        int times;
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


    public boolean Palindrome(String text) {
        boolean result = false;
        int l, r;
        char[] palindrome;
        text = text.toLowerCase();
        text = text.replace(" ", "");
        text = text.replace(",", "");
        text = text.replace("!", "");
        text = text.replace(":", "");
        palindrome = text.toCharArray();
        l = 0;
        r = palindrome.length - 1;
        while (l < r) {
            if (palindrome[l] == palindrome[r]) {
                r--;
                l++;
            } else {
                break;
            }
        }
        if (l == r) {
            result = true;
        }
        return result;
    }

    public void IsPrime(int number) {
        int condition = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                condition++;
            }
        }if (condition != 2) {
            System.out.println("The number " + number + " isn't a prime number");
        }else {
            System.out.println("The number " + number + " is a prime number");
        }

    }
}
