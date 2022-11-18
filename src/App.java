
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        // testing coding function
        String cipher2 = Alghoritm.toCode("IDIOCYOFTENLOOKSLIKEINTELLIGENCE", "WHEATSON");
        System.out.println(cipher2);

        String cipher3 = Alghoritm.toDecode(cipher2, "WHEATSON");
        System.out.println(cipher3);

        JFrame.setDefaultLookAndFeelDecorated(true);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                gui.createGUI();
            }
        });
    }
}