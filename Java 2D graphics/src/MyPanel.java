import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel
{
    Image image;
    MyPanel()
    {
        image = new ImageIcon("Daraa.png").getImage();
        this.setPreferredSize(new Dimension(500, 500));
    }
    public void paint (Graphics g)
    {
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setPaint(Color.RED);
        graphics2D.setStroke(new BasicStroke(5));
        //graphics2D.drawLine(0, 0, 500, 500);
        //graphics2D.setPaint(Color.CYAN);
        //graphics2D.drawRect(0, 0, 100, 100);
        //graphics2D.fillRect(0, 0, 100, 200);
        //graphics2D.setPaint(Color.ORANGE);
        //graphics2D.drawOval(0, 0, 100, 100);
        //graphics2D.fillOval(0, 0, 100, 100);
        //graphics2D.setPaint(Color.RED);
        //graphics2D.drawArc(0, 0, 100, 100,180, 180);
        //graphics2D.fillArc(0, 0, 100, 100,180, 180);
        //int [] xPionts ={150,250,350};
        //int [] yPionts ={300,150,300};
        //graphics2D.setPaint(Color.RED);
        //graphics2D.drawPolygon(xPionts , yPionts, 3);
//        graphics2D.setPaint(Color.GREEN);
//        graphics2D.setFont(new Font("Ink Free", Font.PLAIN, 50));
//        graphics2D.drawString("A N A S WINNER! :)", 50, 50);
        graphics2D.drawImage(image ,0, 0, null);

    }
}
