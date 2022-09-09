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
        for(int i = 1; i < Xset.size(); i++){
            if(Xset.get(i).equals(Xset.get(i-1))){
                Xset.add(i, "X");
            }
        }
        if(Xset.size() % 2 != 0){
            Xset.add("X");
        }
        // for(int i = 0; i < Xset.size(); i++){
        //     System.out.print(Xset.get(i) + " ");
        // }
        
        // main loop
        for (int i = 0; i < Xset.size(); i ++) {
            String bigram = String.format("%s", Xset.get(i));
            result.add(bigram);
        }
        return result;
    }

    static ArrayList<String> coding(List<String> listOfChars, List<String> bigrams){
        ArrayList<String> result = new ArrayList<String>();

        // System.out.println(bigrams);

        for (int i = 0; i < bigrams.size(); i+=2){
            // System.out.print(listOfChars.indexOf(bigrams.get(i)) + " " + listOfChars.indexOf(bigrams.get(i + 1)) + " ");
            int peremen1 = listOfChars.indexOf(bigrams.get(i));
            int peremen2 = listOfChars.indexOf(bigrams.get(i + 1));
            //System.out.println(peremen1 + " " + peremen2);

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
                peremen1 +=1;
                peremen2 +=1;

                if(peremen1 > 4 * ((peremen1-1) / 5 + 1)){
                    peremen1 %= 5;
                }
                else if (peremen2 > 4 * ((peremen2-1) / 5 + 1)){
                    peremen2 %= 5;
                }
                bigrams.set(i, listOfChars.get(peremen1));
                bigrams.set(i+1, listOfChars.get(peremen2));
            }
            else {
                System.out.print(listOfChars.indexOf(bigrams.get(i)) + " " + listOfChars.indexOf(bigrams.get(i + 1)) + " ");

                
            }
        }
        // System.out.println(bigrams.get(i) + " " + bigrams.get(i + 1));
        // System.out.println(listOfChars);
        // System.out.println(bigrams);
        return result;
    }
}
