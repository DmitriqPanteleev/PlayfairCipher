import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {
    // function which biuld list of bigrams
    static ArrayList<String> bigramSplit(String input) {

        // Example:
        // hellow -> he lx lo wx

        // local data
        String[] tmpStr = input.split("");
        ArrayList<String> result = new ArrayList<String>();
        List<String> Xset = Stream.of(tmpStr).collect(Collectors.toList());

        // handling two similar chars
        for (int i = 1; i < Xset.size(); i += 2) {
            if (Xset.get(i).equals(Xset.get(i - 1))) {
                Xset.add(i, "X");
            }
        }
        if (Xset.size() % 2 != 0) {
            Xset.add("X");
        }

        for (int i = 0; i < Xset.size(); i++) {
            String bigram = String.format("%s", Xset.get(i));
            result.add(bigram);
        }
        return result;
    }

    static ArrayList<String> coding(List<String> alphabet, List<String> bigrams) {

        ArrayList<String> result = new ArrayList<String>();

        // running throw bigrams
        for (int i = 0; i < bigrams.size(); i += 2) {

            // init first and second letters' indexes
            int firstLetter = alphabet.indexOf(bigrams.get(i));
            int secondLetter = alphabet.indexOf(bigrams.get(i + 1));

            // rule of common column
            if (Math.abs(firstLetter - secondLetter) % 5 == 0) {
                // find out new indexes
                firstLetter += 5;
                secondLetter += 5;

                // catching for overflow
                if (firstLetter > 25) {
                    firstLetter %= 5;
                } else if (secondLetter > 25) {
                    secondLetter %= 5;
                }
                // setting new coded letters
                bigrams.set(i, alphabet.get(firstLetter));
                bigrams.set(i + 1, alphabet.get(secondLetter));
            }
            // rule of common line
            else if (firstLetter / 5 == secondLetter / 5) {
                //
                if (firstLetter + 1 >= 5 * ((firstLetter) / 5 + 1)) {
                    firstLetter -= 5;
                } else if (secondLetter + 1 >= 5 * ((secondLetter) / 5 + 1)) {
                    secondLetter -= 5;
                }
                firstLetter += 1;
                secondLetter += 1;

                // setting new coded letters
                bigrams.set(i, alphabet.get(firstLetter));
                bigrams.set(i + 1, alphabet.get(secondLetter));
            }
            // rule of rectangle
            else {
                // TODO: - comments
                // difference between the columns
                int count = Math.abs((firstLetter / 5) - (secondLetter / 5));
                //
                int k = 1;

                // flag of ...
                if (secondLetter > firstLetter) {
                    k = -1;
                }

                firstLetter = firstLetter - 5 * count * k;
                secondLetter = secondLetter + 5 * count * k;

                // setting new coded letters
                bigrams.set(i, alphabet.get(secondLetter));
                bigrams.set(i + 1, alphabet.get(firstLetter));
            }
        }
        for (int i = 0; i < bigrams.size(); i++) {
            String cipher = String.format("%s", bigrams.get(i));
            result.add(cipher);
        }
        return result;
    }
}
