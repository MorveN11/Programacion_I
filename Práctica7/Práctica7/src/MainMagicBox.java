public class MainMagicBox {
    public static void main(String[] args) {
        int dimension;
        do {
            System.out.println("Enter an uneven number and bigger than one");
            dimension = Utility.verifyNumber();
        } while (dimension % 2 == 0 || dimension == 1);
        Matrix magicBox = new Matrix(dimension);
        magicBox.showMagicBox();
    }
}
