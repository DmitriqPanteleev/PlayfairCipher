import java.util.*;

class Alghoritm {

    static public String toCode(String input) {
        // local variables
        String keyWord = "JEWERLY";
        String alphabet;
        String[] matrix;

        // building an alphabet
        if (keyWord.contains("i") && keyWord.contains("j")) {
            alphabet = "ABCDEFGHKLMNOPRSTUWXYZ";
        } else if (keyWord.contains("i")) {
            alphabet = "ABCDEFGHKLMNOPQRSTUWXYZ";
        } else if (keyWord.contains("j")) {
            alphabet = "ABCDEFGHKLMNOPQRSTUWXYZ";
        } else {
            alphabet = "ABCDEFGHIKLMNOPQQRSTUWXYZ";
        }

        // building an coded alphabet without any dublicates
        String tmpStr = keyWord + alphabet;
        matrix = tmpStr.split("");

        List<String> tmpList = Arrays.asList(matrix);
        List<String> listOfChars = new ArrayList<>(new LinkedHashSet<>(tmpList));
        // TODO: Avoid prints
        System.out.println(listOfChars);

        // building an bigrams
        List<String> bigrams = new ArrayList<>();
        bigrams = Helper.bigramSplit(input);
        // TODO: Avoid prints
        System.out.println(bigrams);

        return "";
    }

    static public String toDecode(String input) {
        // TODO: - func to decode
        return "";
    }
}