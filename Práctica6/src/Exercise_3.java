import java.util.Arrays;

public class Exercise_3 {
    public static void main(String[] args) {

        final String[] c = Utility.RepeatedWords("This is a repeated word test this is a A");

        System.out.println(Arrays.toString(c));//Should print [this,2,is,2,a, 3, repeated,1, word,1,test,1]

        final String[] c1 = Utility.RepeatedWords("This is a repeated word test this this this this this this");

        System.out.println(Arrays.toString(c1));//Should print [this,7,is,1,a, 1, repeated,1, word,1,test,1]

        final String[] c2 = Utility.RepeatedWords("This is a repeated word test this word word word");

        System.out.println(Arrays.toString(c2));//Should print [this,2,is,1,a, 1, repeated,1, word,4 ,test,1]

    }
}
