import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor extends JFrame implements ActionListener
{
    JTextArea textArea;
    JScrollPane scrollPane;
    JSpinner jSpinner;
    JLabel jLabel;
    JButton jButton;
    JComboBox jComboBox;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem openItem;
    JMenuItem saveItem;
    JMenuItem exitItem;

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

        //---------------menuBar
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");

        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);

        menu.add(openItem);
        menu.add(saveItem);
        menu.add(exitItem);

        menuBar.add(menu);

        //--------------/menubar

        this.setJMenuBar(menuBar);
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
        if (event.getSource() == openItem)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("Text files", "txt");
            fileChooser.setFileFilter(fileNameExtensionFilter);

            int response = fileChooser.showOpenDialog(null);

            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                Scanner scannerfileIn = null;
                try
                {
                    scannerfileIn = new Scanner(file);
                    if (file.isFile())
                    {
                        while (scannerfileIn.hasNextLine())
                        {
                            String line = scannerfileIn.nextLine()+"\n";
                            textArea.append(line);
                        }
                    }
                }
                catch (FileNotFoundException e)
                {
                    throw new RuntimeException(e);
                }
                finally
                {
                    scannerfileIn.close();
                }
            }
        }
        if (event.getSource() == saveItem)
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));

            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION)
            {
                File file;
                PrintWriter fileOut = null;
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut = new PrintWriter(file);
                    fileOut.println(textArea.getText());

                } catch (FileNotFoundException e)
                {
                    throw new RuntimeException(e);
                }
                finally
                {
                    fileOut.close();
                }
            }
        }
        if (event.getSource() == exitItem)
        {
            System.exit(0);
        }
    }
}
