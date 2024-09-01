import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    JTextField jTextField;
    JButton jButton;
    MyFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        jButton = new JButton("Submit");
        jButton.addActionListener(this);

        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(250, 40));
        jTextField.setFont(new Font("Consolas", Font.PLAIN, 35));
        jTextField.setForeground(Color.MAGENTA);
        jTextField.setBackground(Color.CYAN);
        jTextField.setCaretColor(Color.WHITE);
        jTextField.setText("username");


        this.add(jButton);
        this.add(jTextField);
        this.pack();
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == jButton)
        {
            System.out.println("Hello " + jTextField.getText());
            jButton.setEnabled(false);
            jTextField.setEditable(false);
        }
    }
}
