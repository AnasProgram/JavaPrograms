import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    MyPanel myPanel;
    MyFrame()
    {
        myPanel = new MyPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(myPanel);
        this.pack();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
