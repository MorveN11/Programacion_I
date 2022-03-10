public class Utility {
    static String[] Repeated(String text) {
        int repeated = 0, mostRepeated = 0;
        String[] arrayText;
        String[] arrayWords;
        String[] mostRepeatedWord = new String[2];

        text = RefactorText(text);
        int numberWords = NumberWords(text);
        arrayText = FillText(text,numberWords);
        arrayWords = FillWords(text, numberWords);

        for (String word : arrayWords) {
            for (String wordsText : arrayText) {
                if (word.equals(wordsText))
                    repeated++;
            }
            if (repeated > mostRepeated) {
                mostRepeated = repeated;
                mostRepeatedWord[0] = word;
                mostRepeatedWord[1] = String.valueOf(mostRepeated);
            }
            repeated = 0;
        }
        if (mostRepeated == 1) {
            mostRepeatedWord[0] = "Ninguna palabra se repite";
            mostRepeatedWord[1] = "-";
        }
        return mostRepeatedWord;
    }

    static String RefactorText(String text) {
        text = text.replace(".", "");
        text = text.replace(",", "");
        text = text.replace("!", "");
        text = text.toLowerCase();
        text += ' ';
        return text;
    }

    static int NumberWords(String text) {
        int numberWords = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                numberWords++;
        }
        return numberWords;
    }

    static String[] FillText(String text, int numberWords) {
        StringBuilder word = new StringBuilder();
        String[] array = new String[numberWords];
        char character;
        int posArray = 0;

        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) != ' ') {
                character = text.charAt(i);
                word.append(character);
            } else {
                array[posArray++] = String.valueOf(word);
                word = new StringBuilder();
            }
        }
        return array;
    }

    static String[] FillWords(String text, int numberWords) {
        StringBuilder word = new StringBuilder();
        String[] array = new String[numberWords];
        String createdWord;
        char character;
        int posArray = 0;

        for (int i = 0; i < text.length(); i++){
            boolean repeated = false;
            if (text.charAt(i) != ' ') {
                character = text.charAt(i);
                word.append(character);
            } else {
                createdWord = String.valueOf(word);
                for (String wordsText : array) {
                    if (createdWord.equals(wordsText)) {
                        repeated = true;
                        break;
                    }
                }
                if (!repeated) {
                    array[posArray++] = createdWord;

                }
                word = new StringBuilder();
            }
        }
        array = DeleteNulls(array, numberWords);
        return array;
    }

    static String[] DeleteNulls(String[] arrayWords, int numberWords) {
        int numberNulls = 0;
        int posArray = 0;

        for (String words: arrayWords) {
            if(words == null)
                numberNulls++;
        }

        String[] array = new String[numberWords - numberNulls];

        for (int i = 0; i < array.length; i++) {
            array[posArray++] = arrayWords[i];
        }
        return array;
    }

}

