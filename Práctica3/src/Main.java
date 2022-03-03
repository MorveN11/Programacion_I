import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyLibrary math = new MyLibrary();

        final float a = math.Multiply(50, -50);
        System.out.println(a);

        final float b = math.GetBiggest(50, -1500, 1000, 0, 1, 54);
        System.out.println(b);

        math.Repeated("This is a repeated word test this is a A");

        final boolean d = math.Palindrome("A man, a plan, a canal: Panama!");
        System.out.println(d);

        math.IsPrime(2);
        math.IsPrime(4);

    }
}
