import javax.swing.*;
import java.awt.*;

public class ProgressBarDemo
{
    JFrame frame = new JFrame();
    JProgressBar progressBar = new JProgressBar(0, 500);

    ProgressBarDemo()
    {
        progressBar.setValue(0);
        progressBar.setBounds(0, 0, 420, 50);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("MV Boli", Font.BOLD, 25));
        progressBar.setForeground(Color.RED);
        progressBar.setBackground(Color.BLACK);

        frame.add(progressBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }
    public void fill()
    {
        int counter = 500;
        while (counter > 0)
        {
            progressBar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter -=1;
        }
        progressBar.setString("Done!!!");
    }
}
