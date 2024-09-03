import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener
{
    JFrame jFrame = new JFrame();
    JButton jButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JLabel label = new JLabel();
    int elapsedTime = 0;
    int seconds = 0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d", seconds);
    String minutes_string = String.format("%02d", minutes);
    String hours_string = String.format("%02d", hours);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            elapsedTime = elapsedTime + 1000;
            hours = (elapsedTime/3600000);
            minutes = (elapsedTime/60000) % 60;
            seconds = (elapsedTime/1000) % 60;
            seconds_string = String.format("02d", seconds);
            minutes_string = String.format("02d", minutes);
            hours_string = String.format("02d", hours);
            label.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        }
    });
    Stopwatch()
    {
        label.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        label.setBounds(100, 100, 200, 100);
        label.setFont(new Font("Verdana", Font.PLAIN, 35));
        label.setBorder(BorderFactory.createBevelBorder(1));
        label.setOpaque(true);
        label.setHorizontalAlignment(JTextField.CENTER);

        jButton.setBounds(100, 200, 100, 50);
        jButton.setFont(new Font("Ink Free", Font.PLAIN,20));
        jButton.setFocusable(false);
        jButton.addActionListener(this);

        resetButton.setBounds(200, 200, 100, 50);
        resetButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        jFrame.add(jButton);
        jFrame.add(resetButton);
        jFrame.add(label);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420,420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jButton)
        {
            if(started == false)
            {
                started = true;
                jButton.setText("STOP");
                start();
            }
            else
            {
                started=false;
                jButton.setText("START");
                stop();
            }
        }
        if(e.getSource()==resetButton)
        {
            started=false;
            jButton.setText("START");
            reset();
        }
    }
    void start()
    {
        timer.start();
    }

    void stop()
    {
        timer.stop();
    }
    void reset()
    {
        timer.stop();
        elapsedTime=0;
        seconds =0;
        minutes=0;
        hours=0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        label.setText(hours_string+":"+minutes_string+":"+seconds_string);
    }
}
