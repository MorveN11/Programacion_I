import java.util.Arrays;

public class Exercise_2 {
    public static void main(String[] args) {

        final String[] c = Utility.Repeated("This is a repeated word test this is a A");

        System.out.println(Arrays.toString(c));//Should print [a, 3]

        final String[] c1 = Utility.Repeated("This is a repeated word test this this this this this this");

        System.out.println(Arrays.toString(c1));//Should print [this, 7]

        final String[] c2 = Utility.Repeated("This is a repeated word test this word word word");

        System.out.println(Arrays.toString(c2));//Should print [word, 4]

    }
}
