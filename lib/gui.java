
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gui {
    // TODO: - User Interface
    public static void createGUI() {
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField shifr = new JTextField();
        shifr.setBounds(60, 90, 500, 25);
        frame.add(shifr);

        JPanel panelText = new JPanel();
        panelText.setBounds(60, 40,500, 120);

        JTextField textField = new JTextField(35);
        textField.setBounds(60, 40, 500, 40);

        JTextField codewordField = new JTextField(35);
        textField.setBounds(60, 45, 500, 40);

        

        panelText.add(textField);
        panelText.add(codewordField);
        frame.add(panelText);
    

        JPanel panelButton = new JPanel();
        panelButton.setBounds(40, 400, 100, 100);

        JButton cipher = new JButton("Шифровать");
        cipher.setBounds(60, 120, 60, 80);

        JButton decipher = new JButton("Дешифровать");
        decipher.setBounds(150, 120, 60, 80);
        panelButton.add(cipher);
        panelButton.add(decipher);
        frame.add(panelButton);

        ActionListener actionCipher = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                String codew = codewordField.getText();
                
                text = Alghoritm.toCode(text, codew);

                shifr.setText(text);
            }
        };

        cipher.addActionListener(actionCipher);

        ActionListener actionDeCipher = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String text = textField.getText();
                String codew = codewordField.getText();
                
                text = Alghoritm.toDecode(text, codew);

                shifr.setText(text);
            }
        };
        decipher.addActionListener(actionDeCipher);


        frame.setPreferredSize(new Dimension(600, 400));

        frame.pack();
        frame.setVisible(true);
        frame.setLocation(650, 250);
    }
}
