public class Matrix {
    int[][] matrix;
    char[][] game;
    int size;
    int pos_x;
    int pos_y;
    boolean fill = false;
    boolean statusGame = true;
    boolean statusPlayer1 = false;
    boolean statusPlayer2 = false;

    public Matrix(int size){
        this.size = size;
        this.pos_x = 0;
        this.pos_y = size/2;
        this.matrix = new int[this.size][this.size];
    }
    void menuMatrix() {
        int condition;
        int number;
        while (true){
            System.out.println("""
                \t --MENU--\s
                 1- Fill Numbers
                 2- Sum Line
                 3- Sum Column
                 4- Sum Principal Diagonal
                 5- Sum Inverse Diagonal
                 6- Average Numbers
                 7- Quit""");
            condition = Utility.verifyNumber();
            while (condition < 1 || condition > 7) {
                System.out.println("##Error: Invalid Number!\n Select a correct option");
                condition = Utility.verifyNumber();
            }
            if (condition == 1) {
                fillMatrix();
                fill = true;
            }
            if (condition == 7) {
                break;
            }
            if (fill) {
                Utility.printMatrix(size, matrix);
                if (condition == 2) {
                    System.out.println("Enter the line: ");
                    number = verifyLength();
                    System.out.println("The sum of the line "+number+" is: " + lineMatrix(number));
                }
                if (condition == 3) {
                    System.out.println("Enter the column: ");
                    number = verifyLength();
                    System.out.println("The sum of the column "+number+" is: " + columnMatrix(number));
                }
                if (condition == 4) {
                    System.out.println("The sum of the principal diagonal is: " + principalMatrix());
                }
                if (condition == 5) {
                    System.out.println("The sum of the inverse diagonal is: " + inverseMatrix());
                }
                if (condition == 6) {
                    System.out.println("The average is: " + averageMatrix());
                }
            }
            else {
                System.out.println("You must fill the Matrix!!");
            }
        }
    }

    void fillMatrix() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Enter the number[" + i + "][" + j + "]");
                int number = Utility.verifyNumber();
                matrix[i][j] = number;
            }
        }
    }

    int verifyLength() {
        boolean condition = false;
        int number = 0;
        while (!condition){
            number = Utility.verifyNumber();
            if (number >= size || number < 0){
                System.out.println("Line or column incorrect, Check the matrix: ");
                Utility.printMatrix(size, matrix);
            } else {
                condition = true;
            }
        }
        return number;
    }
    int columnMatrix(int number) {
        int result = 0;
        for (int[] ints : matrix) {
            result += ints[number];
        }
        return result;
    }

    int lineMatrix(int number) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += matrix[number][i];
        }
        return result;
    }

    int principalMatrix() {
        int result = 0;
        for (int i = 0; i < size; i++) {
            result += matrix[i][i];
        }
        return result;
    }

    int inverseMatrix() {
        int result = 0;
        int limit = size - 1;
        for (int i = 0; i < size; i++){
            result += matrix[limit][i];
            limit --;
        }
        return result;
    }

    double averageMatrix() {
        double result = 0;
        for (int[] doubles : matrix) {
            for (int j = 0; j < size; j++) {
                result += doubles[j];
            }
        }
        return result/(size*size);
    }

    void showMagicBox() {
        fillMagicMatrix();
        Utility.printMagicBox(size, matrix);
    }

    void fillMagicMatrix() {
        int count = 1;
        int previous_x = 0;
        int previous_y = 0;
        while (count < (size*size)+1) {
            if (matrix[pos_x][pos_y] != 0) {
                pos_x = previous_x + 1;
                pos_y = previous_y;
            }
            matrix[pos_x][pos_y] = count;
            previous_x = pos_x;
            previous_y = pos_y;
            count++;
            pos_y++;
            pos_x--;
            if (pos_x <0 && pos_y == size) {
                pos_x = size -1;
                pos_y = 0;
            } else if (pos_x < 0) {
                pos_x += size;
            } else if (pos_y == size) {
                pos_y = 0;
            }
        }
    }

    public Matrix(){
        this.size = 3;
        this.game = new char[this.size][this.size];
    }

    void fillGame() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                game[i][j] = '-';
            }
        }
    }
    void Game() {
        fillGame();
        while (statusGame){
            Utility.printGame(size, game);
            play(true);
            if (statusGame) {
                Utility.printGame(size, game);
                play(false);
            }
        }
        Utility.printGame(size, game);
        if (statusPlayer1){
            System.out.println("PLAYER 1 WINS");
        } else if (statusPlayer2){
            System.out.println("PLAYER 2 WINS");
        } else {
            System.out.println("DRAW");
        }
    }

    void play(boolean condition){
        if (condition){
            player1();
        } else{
            player2();
        }
        verifyPosLine();
        verifyPosColumn();
        verifyPosDiagonal();
        verifyInverseDiagonal();
        verifyGame();
    }


    int verifyPos() {
        boolean condition = false;
        int number = 0;
        while (!condition){
            number = Utility.verifyNumber();
            if (number > size || number < 1){
                System.out.println("Line or column incorrect, Check the matrix: ");
                Utility.printGame(size, game);
            } else {
                condition = true;
            }
        }
        return number;
    }


    void verifyGame() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (game[i][j] != '-'){
                    count++;
                }
            }
        }
        if (count == (size * size)){
            statusGame = false;
        }
    }

    void player1() {
        System.out.println("\n\tPLAYER1");
        System.out.println("Enter line: ");
        int line = verifyPos();
        line --;
        System.out.println("Enter column: ");
        int column = verifyPos();
        column --;
        if (game[line][column] == 'X' || game[line][column] == 'O'){
            System.out.println("ERROR: Position occupied enter other values!");
            player1();
        } else{
            game[line][column] = 'X';
        }
    }

    void player2() {
        System.out.println("\n\tPLAYER2");
        System.out.println("Enter line: ");
        int line = verifyPos();
        line --;
        System.out.println("Enter column: ");
        int column = verifyPos();
        column --;
        if (game[line][column] == 'X' || game[line][column] == 'O'){
            System.out.println("ERROR: Position occupied enter other values!");
            player2();
        } else{
            game[line][column] = 'O';
        }
    }

    void verifyPosLine(){
        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(game[i][j] == 'X'){
                    count_x++;
                }
                if(game[i][j] == 'O'){
                    count_o++;
                }
            }
            if (count_x == 3) {
                statusPlayer1 = true;
                statusGame = false;
            }
            if (count_o == 3) {
                statusPlayer2 = true;
                statusGame = false;
            }
            count_x = 0;
            count_o = 0;
        }
    }

    void verifyPosColumn(){
        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if(game[j][i] == 'X'){
                    count_x++;
                }
                if(game[j][i] == 'O'){
                    count_o++;
                }
            }
            if (count_x == 3) {
                statusPlayer1 = true;
                statusGame = false;
            }
            if (count_o == 3) {
                statusPlayer2 = true;
                statusGame = false;
            }
            count_x = 0;
            count_o = 0;
        }
    }

    void verifyPosDiagonal(){
        int count_x = 0;
        int count_o = 0;
        for (int i = 0; i < size; i++){
            if(game[i][i] == 'X'){
                count_x++;
                }
            if(game[i][i] == 'O'){
                count_o++;
            }
        }
        if (count_x == 3) {
            statusPlayer1 = true;
            statusGame = false;
        }
        if (count_o == 3) {
            statusPlayer2 = true;
            statusGame = false;
        }
    }

    void verifyInverseDiagonal(){
        int count_x = 0;
        int count_o = 0;
        int limit = size - 1;
        for (int i = 0; i < size; i++){
            if(game[limit][i] == 'X'){
                count_x++;
            }
            if(game[limit][i] == 'O'){
                count_o++;
            }
            limit --;
        }
        if (count_x == 3) {
            statusPlayer1 = true;
            statusGame = false;
        }
        if (count_o == 3) {
            statusPlayer2 = true;
            statusGame = false;
        }
    }
}
