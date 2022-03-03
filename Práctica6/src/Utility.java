public class Utility {
    public static String[] Repeated(String word) {
        int number_repeated = 0,  max_repeated = 0;
        String max_letter = "";

        word = Utility.Order(word);
        int numberWords = Utility.numberWords(word);

        String[] words = Utility.appendArray(numberWords, word);
        String[] no_repeats = Utility.deleteRepeated(numberWords, word);
        String[] no_nulls = Utility.deleteNulls(numberWords, no_repeats);
        String[] result = new String[2];

        for (String pos_words : no_nulls) {
            for (String pos_repeated : words) {
                if (pos_words.equals(pos_repeated)) {
                    number_repeated++;
                }
            }
            if (number_repeated > max_repeated) {
                max_repeated = number_repeated;
                max_letter = pos_words;
            }
            number_repeated = 0;
        }
        result[0] = max_letter;
        result[1] = String.valueOf(max_repeated);
        return result;
    }

    public static String[] RepeatedWords(String word) {
        int pos_array = 1, number_repeated = 0;

        word = Utility.Order(word);
        int numberWords = Utility.numberWords(word);

        String[] no_repeats = Utility.deleteRepeated(numberWords, word);
        String[] result = Utility.deleteNullsWords(numberWords, no_repeats);
        String[] words = Utility.appendArray(numberWords, word);

        for (int i = 0; i < result.length; i += 2) {
            for (String words_array : words) {
                if (result[i].equals(words_array)) {
                    number_repeated++;
                }
            }
            result[pos_array] = String.valueOf(number_repeated);
            pos_array += 2;
            number_repeated = 0;
        }
        return result;
    }

    public static String lengthenPassword(String password, String large) {
        StringBuilder lengthenPassword = new StringBuilder();

        int pos_letter = 0;
        for (int i = 0; i < large.length(); i++) {
            if (large.charAt(i) == ' '){
                lengthenPassword.append(" ");
            }else{
                if (pos_letter < password.length()) {
                    char character = password.charAt(pos_letter);
                    lengthenPassword.append(character);
                } else {
                    pos_letter = 0;
                    char character = password.charAt(pos_letter);
                    lengthenPassword.append(character);
                }
                pos_letter++;
            }
            }
        return String.valueOf(lengthenPassword);
    }

    public static String Encryption(String message, String password, boolean inverse) {
        String alphabet = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        StringBuilder encryption = new StringBuilder();

        int pos_letter = 0, pos_x = 0, pos_y = 0, pos_z;
        char character;

        while (pos_letter < message.length()) {
            if (message.charAt(pos_letter) == ' '){
                encryption.append(" ");
            }else{
                for (int i = 0; i < alphabet.length(); i++) {
                    if (message.charAt(pos_letter) == alphabet.charAt(i)) {
                        pos_x = i;
                    }
                    if (password.charAt(pos_letter) == alphabet.charAt(i)) {
                        pos_y = i;
                    }
                }
                if (!inverse) {
                    pos_z = (pos_x + pos_y) % alphabet.length();
                }
                else {
                    pos_z = (pos_x -pos_y) % alphabet.length();
                    if (pos_z < 0) {
                        pos_z = alphabet.length() + pos_z;
                    }
                }
                character = alphabet.charAt(pos_z);
                encryption.append(character);
            }
            pos_letter++;
        }
        return String.valueOf(encryption);
    }

    public static String Refactor(String word){
        word = word.replace(",", "");
        word = word.replace("!", "");
        word = word.toUpperCase();
        return word;
    }

    public static String Order(String word){
        word = word.replace(",", "");
        word = word.replace("!", "");
        word = word + " ";
        word = word.toLowerCase();
        return word;
    }

    public static int numberWords(String word) {
        int numberWords = 0;

        for (int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            if (character == ' '){
                numberWords++;
            }
        }
        return numberWords;
    }

    public static String[] appendArray(int numberWords, String word) {
        StringBuilder create_word = new StringBuilder();
        String[] array = new String[numberWords];

        int pos_array = 0;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character != ' ' ) {
                create_word.append(character);
            }else {
                array[pos_array] = String.valueOf(create_word);
                create_word = new StringBuilder();
                pos_array++;
            }
        }
        return array;
    }

    public static String[] deleteRepeated(int numberWords, String word){
        StringBuilder create_word = new StringBuilder();
        String[] array = new String[numberWords];
        String created;

        boolean status = false;
        int pos_array = 0;

        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character != ' ' ) {
                create_word.append(character);
            } else {
                for (String words_array : array) {
                    created = String.valueOf(create_word);
                    if (created.equals(words_array)) {
                        status = true;
                        break;
                    }
                }
                if (!status){
                    array[pos_array] = String.valueOf(create_word);
                    pos_array++;
                }
                create_word = new StringBuilder();
                status = false;
            }
        }
        return array;
    }

    public static String[] deleteNullsWords(int numberWords, String[] first_array){
        int numberNulls = 0;
        int pos_array = 0;

        for (String position : first_array) {
            if (position == null) {
                numberNulls += 1;

            }
        }
        String[] result = new String[(numberWords - numberNulls)*2];

        for (int i = 0; i < (numberWords - numberNulls); i++){
            result[pos_array] = first_array[i];
            pos_array += 2;
        }
        return result;
    }

    public static String[] deleteNulls(int numberWords, String[] first_array){
        int numberNulls = 0;
        int pos_array = 0;

        for (String position : first_array) {
            if (position == null) {
                numberNulls += 1;

            }
        }
        String[] result = new String[(numberWords - numberNulls)];

        for (int i = 0; i < (numberWords - numberNulls); i++){
            result[pos_array] = first_array[i];
            pos_array ++;
        }
        return result;

    }
}




