import java.util.*;

class Alghoritm {

    static public String toCode(String input) {
        // local variables
        String keyWord = "WHEATSON";
        String alphabet;
        String[] matrix;

        // building an alphabet
<<<<<<< HEAD
        if (keyWord.contains("i") && keyWord.contains("j")) {
            alphabet = "ABCDEFGHKLMNOPRSTUVWXYZ";
        } else if (keyWord.contains("i")) {
            alphabet = "ABCDEFGHKLMNOPQRSTUVWXYZ";
        } else if (keyWord.contains("j")) {
=======
        if (keyWord.contains("I") && keyWord.contains("J")) {
            alphabet = "ABCDEFGHKLMNOPRSTUVWXYZ";
        } else if (keyWord.contains("I")) {
            alphabet = "ABCDEFGHKLMNOPQRSTUVWXYZ";
        } else if (keyWord.contains("J")) {
>>>>>>> c2795d9f614e8f25810a1c6f5e2a085cc13ae994
            alphabet = "ABCDEFGHKLMNOPQRSTUVWXYZ";
        } else {
            alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        }

        // building an coded alphabet without any dublicates
        String tmpStr = keyWord + alphabet;
        matrix = tmpStr.split("");

        List<String> tmpList = Arrays.asList(matrix);
        List<String> listOfChars = new ArrayList<>(new LinkedHashSet<>(tmpList));
        // TODO: Avoid prints
        // System.out.println(listOfChars);

        // building an bigrams
        List<String> bigrams = new ArrayList<>();
        bigrams = Helper.bigramSplit(input);
        // TODO: Avoid prints
        // System.out.println(bigrams);

        List<String> cipher = new ArrayList<>();
        cipher = Helper.coding(listOfChars, bigrams);
        System.out.println(cipher);

        return "";
    }

    static public String toDecode(String input) {
        // TODO: - func to decode
        return "";
    }
}