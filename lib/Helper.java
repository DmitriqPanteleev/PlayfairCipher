import java.util.ArrayList;

public class Helper {
    // function which biuld list of bigrams
    static ArrayList<String> bigramSplit(String input) {

        // Example:
        // hellow -> he lx lo wx

        // local data
        int n = input.length();
        String[] tmpStr = input.split("");

        ArrayList<String> result = new ArrayList<String>();

        // handling two similar chars
        for (int i = 0; i < n; i++) {
            if (tmpStr[i] == tmpStr[i + 1]) {
                // TODO: - adding 'x' between two similar chars
            }
        }

        // main loop
        for (int i = 0; i < n; i += 2) {
            // handling last char when it has no pair
            if (i == n - 1) {
                result.add(String.format("%sx", tmpStr[i]));
                break;
            }

            String bigram = String.format("%s%s", tmpStr[i], tmpStr[i + 1]);
            result.add(bigram);
        }

        return result;
    }
}
