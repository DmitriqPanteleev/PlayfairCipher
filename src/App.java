import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // testing coding function
        String cipher2 = Alghoritm.toCode("IDIOCYOFTENLOOKSLIKEINTELLIGENCE", "WHEATSON");
        System.out.println(cipher2);

        String cipher3 = Alghoritm.toDecode(cipher2, "WHEATSON");
        System.out.println(cipher3);
    }
}
