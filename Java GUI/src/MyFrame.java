import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.*;

public class MyFrame extends JFrame
{
    MyFrame()
    {
        this.setTitle("Java GUI by Anas"); // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false); //prevent frame from being resized
        this.setSize(420, 420); // set the x-dimension, and y-dimension of frame
        this.setVisible(true); //make frame visible

        ImageIcon imageIcon = new ImageIcon("heart-tracker.png"); // creat an ImageIcon
        this.setIconImage(imageIcon.getImage()); // change icon of frame
        this.getContentPane().setBackground(Color.green); // change color of background
    }
}
