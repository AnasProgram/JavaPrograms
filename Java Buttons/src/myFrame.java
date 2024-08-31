import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myFrame extends JFrame implements ActionListener
{
    JButton jButton;
    myFrame()
    {
        jButton = new JButton();
        jButton.setBounds(100, 100, 250, 100);
        jButton.addActionListener(this);
        jButton.setFocusable(false);
        jButton.setText("I'm a button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(jButton);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jButton)
        {
            System.out.println("Hello to my world");
        }
    }
}
