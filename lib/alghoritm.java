import java.util.*;

class Alghoritm {

    static public String toCode(String Letter, String CodeWord) {
        // building an coded string

        List<String> aphabet = Helper.codeAlphabet(CodeWord);

        List<String> bigrams = Helper.bigrams(Letter, 1);

        List<String> cipher = Helper.alghoritm(bigrams, aphabet, 1);

        String tocode = String.join("", cipher);

        return tocode;
    }

    static public String toDecode(String Letter, String CodeWord) {

        List<String> aphabet = Helper.codeAlphabet(CodeWord);

        List<String> bigrams = Helper.bigrams(Letter, 1);

        List<String> decipher = Helper.alghoritm(bigrams, aphabet, -1);

        if(decipher.get(decipher.size()-1).equals("X") && decipher.size()%2 == 0){
            decipher.remove(decipher.lastIndexOf("X"));
        }

        for (int i = 1; i < decipher.size(); i += 2) {
            if (decipher.get(i+1).equals(decipher.get(i - 1)) && decipher.get(i).equals("X")) {
                decipher.remove(i);
            }
            if(!decipher.contains("X")){
                break;
            }
        }
        String todecode = String.join("", decipher);
    
        return todecode;
    }
}