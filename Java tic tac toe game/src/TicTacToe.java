import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener
{
    Random random = new Random();
    JFrame jFrame =new JFrame();
    JPanel title_jPanel = new JPanel();
    JPanel button_jPanel = new JPanel();
    JLabel textField = new JLabel();
    JButton[] jButtons = new JButton[9];
    boolean player1_turn;

    TicTacToe()
    {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(800, 800);
        jFrame.getContentPane().setBackground(new Color(50,50, 50));
        jFrame.setLayout(new BorderLayout());
        jFrame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        title_jPanel.setLayout(new BorderLayout());
        title_jPanel.setBounds(0, 0, 800, 100);

        button_jPanel.setLayout(new GridLayout(3, 3));
        button_jPanel.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < 9; i++)
        {
            jButtons[i] = new JButton();
            button_jPanel.add(jButtons[i]);
            jButtons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            jButtons[i].setFocusable(false);
            jButtons[i].addActionListener(this);

        }

        title_jPanel.add(textField);
        jFrame.add(title_jPanel, BorderLayout.NORTH);
        jFrame.add(button_jPanel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 9; i++)
        {
            if (e.getSource() == jButtons[i])
            {
                if (player1_turn)
                {
                    if (jButtons[i].getText() == "")
                    {
                        jButtons[i].setForeground(new Color(255, 0 ,0));
                        jButtons[i].setText("X");
                        player1_turn = false;
                        textField.setText("O turn");
                    }
                }
                else
                {
                    if (jButtons[i].getText() == "")
                    {
                        jButtons[i].setForeground(new Color(0, 0 ,255));
                        jButtons[i].setText("O");
                        player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }

    public void firstTurn()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        if (random.nextInt(2) == 0)
        {
            player1_turn = true;
            textField.setText("X turn");
        }
        else
        {
            player1_turn= false;
            textField.setText(" O turn");
        }
    }

    public void check()
    {
        //check X win conditions
        if ((jButtons[0].getText() == "X") && (jButtons[1].getText() == "X") && (jButtons[2].getText() == "X"))
        {
            xWins(0, 1, 2);
        }
        if ((jButtons[3].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[5].getText() == "X"))
        {
            xWins(3, 4, 5);
        }
        if ((jButtons[6].getText() == "X") && (jButtons[7].getText() == "X") && (jButtons[8].getText() == "X"))
        {
            xWins(6, 7, 8);
        }
        if ((jButtons[0].getText() == "X") && (jButtons[3].getText() == "X") && (jButtons[6].getText() == "X"))
        {
            xWins(0, 3, 6);
        }
        if ((jButtons[1].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[7].getText() == "X"))
        {
            xWins(1, 4, 7);
        }
        if ((jButtons[2].getText() == "X") && (jButtons[5].getText() == "X") && (jButtons[8].getText() == "X"))
        {
            xWins(2, 5, 8);
        }
        if ((jButtons[0].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[8].getText() == "X"))
        {
            xWins(0, 4, 8);
        }
        if ((jButtons[2].getText() == "X") && (jButtons[4].getText() == "X") && (jButtons[6].getText() == "X"))
        {
            xWins(2, 4, 6);
        }
        //check O win conditions
        if ((jButtons[0].getText() == "O") && (jButtons[1].getText() == "O") && (jButtons[2].getText() == "O"))
        {
            oWins(0, 1, 2);
        }
        if ((jButtons[3].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[5].getText() == "O"))
        {
            oWins(3, 4, 5);
        }
        if ((jButtons[6].getText() == "O") && (jButtons[7].getText() == "O") && (jButtons[8].getText() == "O"))
        {
            oWins(6, 7, 8);
        }
        if ((jButtons[0].getText() == "O") && (jButtons[3].getText() == "O") && (jButtons[6].getText() == "O"))
        {
            oWins(0, 3, 6);
        }
        if ((jButtons[1].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[7].getText() == "O"))
        {
            oWins(1, 4, 7);
        }
        if ((jButtons[2].getText() == "O") && (jButtons[5].getText() == "O") && (jButtons[8].getText() == "O"))
        {
            oWins(2, 5, 8);
        }
        if ((jButtons[0].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[8].getText() == "O"))
        {
            oWins(0, 4, 8);
        }
        if ((jButtons[2].getText() == "O") && (jButtons[4].getText() == "O") && (jButtons[6].getText() == "O"))
        {
            oWins(2, 4, 6);
        }
    }

    public void xWins(int a, int b, int c)
    {
        jButtons[a].setBackground(Color.GREEN);
        jButtons[b].setBackground(Color.GREEN);
        jButtons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++)
        {
            jButtons[i].setEnabled(false);
        }
        textField.setText("X Wins");
    }

    public void oWins(int a, int b, int c)
    {
        jButtons[a].setBackground(Color.GREEN);
        jButtons[b].setBackground(Color.GREEN);
        jButtons[c].setBackground(Color.GREEN);
        for (int i = 0; i < 9; i++)
        {
            jButtons[i].setEnabled(false);
        }
        textField.setText("O Wins");
    }
}
