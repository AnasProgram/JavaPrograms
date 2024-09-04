import javax.swing.*;
import java.awt.*;

public class WelcomePage
{
    JFrame jFrame = new JFrame();
    JLabel jLabel = new JLabel("Hello!");

    WelcomePage()
    {
        jLabel.setBounds(0, 0, 200, 35);
        jLabel.setFont(new Font(null, Font.PLAIN, 25));

        jFrame.add(jLabel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420, 420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
}
