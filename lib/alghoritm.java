import java.util.*;

class Alghoritm {

    static public String toCode(String input) {
        // local variables
        String keyWord = "WHEATSON";
        String alphabet;
        String[] matrix;

        // building an alphabet
        if (keyWord.contains("i") && keyWord.contains("j")) {
            alphabet = "ABCDEFGHKLMNOPRSTUVWXYZ";
        } else if (keyWord.contains("i")) {
            alphabet = "ABCDEFGHKLMNOPQRSTUVWXYZ";
        } else if (keyWord.contains("j")) {
<<<<<<< HEAD

=======
>>>>>>> origin
            alphabet = "ABCDEFGHKLMNOPQRSTUVWXYZ";
        } else {
            alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        }

        // building an coded alphabet without any dublicates
        String tmpStr = keyWord + alphabet;
        matrix = tmpStr.split("");

        List<String> tmpList = Arrays.asList(matrix);
        List<String> charsOfAlphabet = new ArrayList<>(new LinkedHashSet<>(tmpList));

        // building an bigrams
        List<String> bigrams = new ArrayList<>();
        bigrams = Helper.bigramSplit(input);

        // building an coded string
        List<String> cipher = new ArrayList<>();
        cipher = Helper.coding(charsOfAlphabet, bigrams);
        System.out.println(cipher);

        return "";
    }

    static public String toDecode(String input) {
        // TODO: - func to decode
        return "";
    }
}