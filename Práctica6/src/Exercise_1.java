import java.util.Scanner;

public class Exercise_1 {
    public static void main(String[] args) {
        boolean status = true;
        while(status){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select the operation: \n1.Encrypt\n2.Decrypt\n0.Exit");
            int condition = scanner.nextInt();
            if (condition==1){
                Scanner s = new Scanner(System.in);
                System.out.println("Message: ");
                String message = Utility.Refactor(s.nextLine());

                System.out.println("Password: ");
                String password = Utility.Refactor(s.nextLine());

                String lengthen_password = Utility.lengthenPassword(password, message);
                String encrypt = Utility.Encryption(message, lengthen_password, false);
                System.out.println("Complete:");
                System.out.println(encrypt);
            }
            if (condition==2){
                Scanner c = new Scanner(System.in);
                System.out.println("Encrypt: ");
                String encrypt2 = Utility.Refactor(c.nextLine());

                System.out.println("Password: ");
                String password2 = Utility.Refactor(c.nextLine());

                String lengthen_password2 = Utility.lengthenPassword(password2, encrypt2);
                String message2 = Utility.Encryption(encrypt2, lengthen_password2, true);
                System.out.println("Complete:");
                System.out.println(message2);
            }
            if (condition==0){
                status = false;
            }
        }
    }
}