import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Helper {
    // function which biuld list of bigrams
    static ArrayList<String> bigramSplit(String input) {

        // Example:
        // hellow -> he lx lo wx

        // local data
        int n = input.length();
        String[] tmpStr = input.split("");

        Boolean parity;

        ArrayList<String> result = new ArrayList<String>();

        List<String> Xset = Stream.of(tmpStr).collect(Collectors.toList());

        // handling two similar chars
        for(int i = 1; i < Xset.size(); i++){
            if(Xset.get(i).equals(Xset.get(i-1))){
                Xset.add(i, "X");
            }
        }
        if(Xset.size() % 2 != 0){
            Xset.add("X");
        }
        for(int i = 0; i < Xset.size(); i++){
            System.out.print(Xset.get(i) + " ");
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
