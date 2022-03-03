import java.util.Scanner;


public class Exercise4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        int l, r;
        String text;
        char [] palindrome;
        System.out.println("Enter the text: ");

        text = scanner.nextLine();
        text = text.toLowerCase();
        text = text.replace(" ","");
        text = text.replace(",","");
        text = text.replace("!","");
        text = text.replace(":","");

        palindrome = text.toCharArray();
        l = 0;
        r = palindrome.length - 1 ;

        while(l < r){
            if(palindrome[l] == palindrome[r]){
                r --;
                l ++;
            }else{
                System.out.println("The text isn't a palindrome");
                break;
            }
        }if (l == r){
            System.out.println("The text is a palindrome");
        }

    }
}
