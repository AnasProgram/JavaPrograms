import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage implements ActionListener
{
    JFrame jFrame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JTextField userIDField =new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel("This is not a reel app :)");
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    LoginPage(HashMap<String, String> loginInfoOriginal)
    {
        loginInfo = loginInfoOriginal;

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50, 150, 75, 25);

        jFrame.add(userIDLabel);
        jFrame.add(userPasswordField);

        messageLabel.setBounds(125, 250, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        jFrame.add(userIDLabel);
        jFrame.add(userPasswordLabel);
        jFrame.add(messageLabel);
        jFrame.add(userIDField);
        jFrame.add(userPasswordField);
        jFrame.add(loginButton);
        jFrame.add(resetButton);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(420, 420);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == resetButton)
        {
            userIDField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == loginButton)
        {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID))
            {
                if (loginInfo.get(userID).equals(password))
                {
                    messageLabel.setForeground(Color.GREEN);
                    messageLabel.setText("Login successful!");
                    jFrame.dispose();
                    WelcomePage welcomePage = new WelcomePage();
                }
                else
                {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong password!");
                }
            }
            else
            {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found!");
            }
        }
    }
}
