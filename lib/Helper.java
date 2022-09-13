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
        for(int i = 1; i < Xset.size(); i+=2){
            if(Xset.get(i).equals(Xset.get(i-1))){
                Xset.add(i, "X");
            }
        }
        if(Xset.size() % 2 != 0){
            Xset.add("X");
        }


        for (int i = 0; i < Xset.size(); i ++) {
            String bigram = String.format("%s", Xset.get(i));
            result.add(bigram);
        }
        return result;
    }

    static ArrayList<String> coding(List<String> listOfChars, List<String> bigrams){
        ArrayList<String> result = new ArrayList<String>();

        for (int i = 0; i < bigrams.size(); i+=2){

            int peremen1 = listOfChars.indexOf(bigrams.get(i));
            int peremen2 = listOfChars.indexOf(bigrams.get(i + 1));

            if(Math.abs(peremen1 - peremen2) % 5 == 0){
                peremen1 += 5;
                peremen2 += 5;
                if(peremen1 > 25){
                    peremen1 %= 5;
                }
                else if (peremen2 > 25){
                    peremen2 %=5;
                }
                bigrams.set(i, listOfChars.get(peremen1));
                bigrams.set(i+1, listOfChars.get(peremen2));
            }
            else if(peremen1 / 5 == peremen2 / 5){
                if(peremen1 + 1 >= 5 * ((peremen1) / 5 + 1)){
                    peremen1 -=5;
                }
                else if (peremen2 + 1 >= 5 * ((peremen2) / 5 + 1)){
                    peremen2 -=5;
                }
                peremen1 +=1;
                peremen2 +=1;
                bigrams.set(i, listOfChars.get(peremen1));
                bigrams.set(i+1, listOfChars.get(peremen2));
            }
            else {
                int count = Math.abs((peremen1/5) - (peremen2/5));
                int k = 1;
                if(peremen2 > peremen1)
                    k = -1;
                peremen1 = peremen1 - 5 * count * k;
                peremen2 = peremen2 + 5 * count * k;
                bigrams.set(i, listOfChars.get(peremen2));
                bigrams.set(i+1, listOfChars.get(peremen1));
            }
        }
        for (int i = 0; i < bigrams.size(); i ++) {
            String cipher = String.format("%s", bigrams.get(i));
            result.add(cipher);
        }
        return result;
    }
}
