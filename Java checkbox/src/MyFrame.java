import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    JButton jButton;
    JCheckBox jCheckBox;
    MyFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        jButton = new JButton();
        jButton.setText("submit");
        jButton.addActionListener(this);

        jCheckBox = new JCheckBox();
        jCheckBox.setText("I'm not a robot! I'm a human!");
        jCheckBox.setFocusable(false);
        jCheckBox.setFont(new Font("Consolas", Font.PLAIN, 35));

        this.add(jButton);
        this.add(jCheckBox);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jButton)
        {
            System.out.println(jCheckBox.isSelected());
        }
    }
}
