import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        //JLabel = a GUI display area for a string of text, an image, or both!
        ImageIcon imageIcon = new ImageIcon("1465612.png");
        Border border = BorderFactory.createLineBorder(Color.cyan,3);

        JLabel label = new JLabel(); // create a label
        label.setText("Anas, do you even code?"); //set text of label
        label.setIcon(imageIcon);
        label.setHorizontalTextPosition(JLabel.CENTER); // set text left, center or right of imageicon
        label.setVerticalTextPosition(JLabel.TOP); //set text top, center or bottom of imageicon
        label.setForeground(new Color(0x00ff00)); //set font color of text
        label.setFont(new Font("MV Boli", Font.ITALIC, 50)); //set font of text
        label.setIconTextGap(-25); //sewt gap of text to imageicon
        label.setBackground(Color.white); // set background color
        label.setOpaque(true); //display background color
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label in the center
        label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
        label.setBounds(100, 100, 550, 550); //set x,y position within frame as well as dimension

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(500, 500);
//        frame.setLayout(null);
        //frame set layout null
        frame.setVisible(true);
        frame.add(label);
        frame.pack();
    }
}