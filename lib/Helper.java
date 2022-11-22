import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {
    // function which biuld list of bigrams
    static public List<String> codeAlphabet(String input) {

        String alphabet;
        String[] matrix;

        // building an alphabet
        if (input.contains("i") && input.contains("j")) {
            alphabet = "ABCDEFGHIJKLMNOPRSTUVWXYZ";
        } else if (input.contains("i")) {
            alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        } else if (input.contains("j")) {
            alphabet = "ABCDEFGHJKLMNOPQRSTUVWXYZ";
        } else {
            alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        }

        // building an coded alphabet without any dublicates
        String tmpStr = input + alphabet;
        matrix = tmpStr.split("");

        List<String> tmpList = Arrays.asList(matrix);
        List<String> charsOfAlphabet = new ArrayList<>(new LinkedHashSet<>(tmpList));
        return charsOfAlphabet;
    }

    static ArrayList<String> bigrams(String input, int k) {

        // Example:
        // hellow -> he lx lo wx

        // local data
        String tmp = input.replaceAll(" ", "");
        String[] tmpStr = tmp.split("");
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
        switch (k) {
            case 0:
                for (int i = 0; i < Xset.size(); i += 2) {
                    String bigram = String.format("%s", Xset.get(i) + "" + Xset.get(i + 1));
                    result.add(bigram);
                }
                break;

            case 1:
                for (int i = 0; i < Xset.size(); i++) {
                    String bigram = String.format("%s", Xset.get(i));
                    result.add(bigram);
                }
                break;

            default:
                System.out.println("What");
                break;
        }
        return result;
    }

    static public List<String> alghoritm(List<String> bigrams, List<String> alphabet, int l) {
        for (int i = 0; i < bigrams.size(); i += 2) {

            // init first and second letters' indexes
            int firstLetter = alphabet.indexOf(bigrams.get(i));
            int secondLetter = alphabet.indexOf(bigrams.get(i + 1));

            // rule of common column
            if (Math.abs(firstLetter - secondLetter) % 5 == 0) {
                // find out new indexes
                firstLetter += 5 * l;
                secondLetter += 5 * l;

                // catching for overflow
                if (firstLetter > 25 || firstLetter < 0) {
                    firstLetter -= 25 * l;
                } else if (secondLetter > 25 || secondLetter < 0) {
                    secondLetter -= 25 * l;
                }
                // setting new coded letters
                bigrams.set(i, alphabet.get(firstLetter));
                bigrams.set(i + 1, alphabet.get(secondLetter));
            }
            // rule of common line
            else if (firstLetter / 5 == secondLetter / 5) {
                //
                switch (l) {
                    case -1:
                        if (firstLetter + 1 == 5 * (firstLetter / 5) + 1) {
                            firstLetter += 5;
                        } else if (secondLetter + 1 == 5 * (secondLetter / 5) + 1) {
                            secondLetter += 5;
                        }
                        break;
                    case 1:
                        if (firstLetter + 1 == 5 * ((firstLetter) / 5 + 1)) {
                            firstLetter -= 5;
                        } else if (secondLetter + 1 == 5 * ((secondLetter) / 5 + 1)) {
                            secondLetter -= 5;
                        }
                        break;
                }

                firstLetter += 1 * l;
                secondLetter += 1 * l;

                // setting new coded letters
                bigrams.set(i, alphabet.get(firstLetter));
                bigrams.set(i + 1, alphabet.get(secondLetter));
            }
            // rule of rectangle
            else {
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
        return bigrams;
    }
}
