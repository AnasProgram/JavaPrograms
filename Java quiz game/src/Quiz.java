import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener
{
    String[] questions = {"Which company created Java?", "Which year was Java created?", "What was Java originally called?",
                            "Who is credited with creating Java"};
    String[][] options = {{"Sun Microsystems", "Starbucks", "Microsoft", "Alphabet"}, {"1989", "1996", "1972", "1492"},
                            {"Apple", "Latte", "Oak", "Koffing"},
                            {"Steve Jobs", "Bill Gates","James Gosling", "Mark Zuckerburg"}};
    char[] answers = {'A','B', 'C', 'D'};
    char guess;
    char answer;
    int index;
    int correct_guesses= 0;
    int total_question = questions.length;
    int result;
    int seconds = 10;

    JFrame jFrame = new JFrame();
    JTextField jTextField = new JTextField();
    JTextArea jTextArea = new JTextArea();
    JButton jButtonA = new JButton();
    JButton jButtonB = new JButton();
    JButton jButtonC = new JButton();
    JButton jButtonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0)
            {
                displayAnswer();
            }
        }
    });
    public Quiz()
    {
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(650, 650);
        jFrame.getContentPane().setBackground(new Color(50, 50, 50));
        jFrame.setLayout(null);
        jFrame.setResizable(false);

        jTextField.setBounds(0, 0, 650, 50);
        jTextField.setBackground(new Color(25, 25, 25));
        jTextField.setForeground(new Color(25, 255, 0));
        jTextField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        jTextField.setBorder(BorderFactory.createBevelBorder(1));
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        jTextField.setEditable(false);

        jTextArea.setBounds(0, 50, 650, 50);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(true);

        jTextArea.setBackground(new Color(25, 25, 25));
        jTextArea.setForeground(new Color(25, 255, 0));
        jTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        jTextArea.setBorder(BorderFactory.createBevelBorder(1));
        jTextArea.setEditable(false);

        jButtonA.setBounds(0, 100, 100, 100);
        jButtonA.setFont(new Font("MV Boli", Font.BOLD, 35));
        jButtonA.setFocusable(false);
        jButtonA.addActionListener(this);
        jButtonA.setText("A");

        jButtonB.setBounds(0, 200, 100, 100);
        jButtonB.setFont(new Font("MV Boli", Font.BOLD, 35));
        jButtonB.setFocusable(false);
        jButtonB.addActionListener(this);
        jButtonB.setText("B");

        jButtonC.setBounds(0, 300, 100, 100);
        jButtonC.setFont(new Font("MV Boli", Font.BOLD, 35));
        jButtonC.setFocusable(false);
        jButtonC.addActionListener(this);
        jButtonC.setText("C");

        jButtonD.setBounds(0, 400, 100, 100);
        jButtonD.setFont(new Font("MV Boli", Font.BOLD, 35));
        jButtonD.setFocusable(false);
        jButtonD.addActionListener(this);
        jButtonD.setText("D");

        answer_labelA.setBounds(125, 100, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answer_labelB.setBounds(125, 200, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answer_labelC.setBounds(125, 300, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));

        answer_labelD.setBounds(125, 400, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));

        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("SansSerif", Font.PLAIN, 50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(535, 475, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer >:D");

        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("SansSerif", Font.PLAIN, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("SansSerif", Font.PLAIN, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);


        jFrame.add(seconds_left);
        jFrame.add(time_label);
        jFrame.add(answer_labelA);
        jFrame.add(answer_labelB);
        jFrame.add(answer_labelC);
        jFrame.add(answer_labelD);
        jFrame.add(jButtonA);
        jFrame.add(jButtonB);
        jFrame.add(jButtonC);
        jFrame.add(jButtonD);
        jFrame.add(jTextArea);
        jFrame.add(jTextField);
        jFrame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion()
    {
        if (index >= total_question)
        {
            results();
        }
        else
        {
            jTextField.setText("Question "+ (index+1));
            jTextArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);

            timer.start();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        jButtonA.setEnabled(false);
        jButtonB.setEnabled(false);
        jButtonC.setEnabled(false);
        jButtonD.setEnabled(false);

        if (e.getSource() == jButtonA)
        {
            answer ='A';
            if (answer == answers[index])
            {
                correct_guesses++;
            }
        }
        if (e.getSource() == jButtonB)
        {
            answer ='B';
            if (answer == answers[index])
            {
                correct_guesses++;
            }
        }
        if (e.getSource() == jButtonC)
        {
            answer ='C';
            if (answer == answers[index])
            {
                correct_guesses++;
            }
        }
        if (e.getSource() == jButtonD)
        {
            answer ='D';
            if (answer == answers[index])
            {
                correct_guesses++;
            }
        }
        displayAnswer();
    }
    public void displayAnswer()
    {
        timer.stop();
        jButtonA.setEnabled(false);
        jButtonB.setEnabled(false);
        jButtonC.setEnabled(false);
        jButtonD.setEnabled(false);

        if (answers[index] != 'A')
        {
            answer_labelA.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'B')
        {
            answer_labelB.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'C')
        {
            answer_labelC.setForeground(new Color(255, 0, 0));
        }
        if (answers[index] != 'D')
        {
            answer_labelD.setForeground(new Color(255, 0, 0));
        }
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                jButtonA.setEnabled(true);
                jButtonB.setEnabled(true);
                jButtonC.setEnabled(true);
                jButtonD.setEnabled(true);

                index++;

                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results()
    {
        jButtonA.setEnabled(false);
        jButtonB.setEnabled(false);
        jButtonC.setEnabled(false);
        jButtonD.setEnabled(false);

        result = (int)((correct_guesses/(double)total_question)*100);
        jTextField.setText("results");
        jTextArea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("("+correct_guesses+"/"+total_question+")");
        percentage.setText(result+"%");

        jFrame.add(number_right);
        jFrame.add(percentage);

    }
}
