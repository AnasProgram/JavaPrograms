import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEditor extends JFrame implements ActionListener
{
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner jSpinner;
    JLabel jLabel;
    JButton jButton;
    JComboBox jComboBox;
    TextEditor()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Anas text Editor");
        this.setSize(500, 500);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 50));
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jLabel = new JLabel("Font: ");

        jSpinner = new JSpinner();
        jSpinner.setPreferredSize(new Dimension(50, 25));
        jSpinner.setValue(20);
        jSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e)
            {
                textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN,(int) jSpinner.getValue()));
            }
        });
        jButton = new JButton("Color");
        jButton.addActionListener(this);


        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        jComboBox = new JComboBox(fonts);
        jComboBox.addActionListener(this);
        jComboBox.setSelectedItem("Arial");


        this.add(jLabel);
        this.add(jSpinner);
        this.add(jButton);
        this.add(jComboBox);
        this.add(scrollPane);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent event)
    {
        if (event.getSource() == jButton)
        {
            JColorChooser jColorChooser = new JColorChooser();

            Color color = JColorChooser.showDialog(null, "Choose a color", Color.black);
            textArea.setForeground(color);
        }
        if (event.getSource() == jComboBox)
        {
            textArea.setFont(new Font((String) jComboBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }
    }
}
