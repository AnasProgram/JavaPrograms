import javax.swing.*;

import static javax.swing.JOptionPane.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        // JOptionPane = pop up a stand dialog box that prompts users for a value
        //               or informs them of something.

//        JOptionPane.showMessageDialog(null, "This is some unless info!", "Anas's Project!", JOptionPane.PLAIN_MESSAGE);
//        JOptionPane.showMessageDialog(null,"Here is more usless info!", "Anas's Project", JOptionPane.INFORMATION_MESSAGE);
//        JOptionPane.showMessageDialog(null, "really?", "Anas's Project!", JOptionPane.QUESTION_MESSAGE);
//        while (true) {
//        JOptionPane.showMessageDialog(null, "Your computer has a virus!!!", "Anas's Project!", JOptionPane.WARNING_MESSAGE);
//        }
//        JOptionPane.showMessageDialog(null, "Call tech support now!!!!", "Anas's Project!", JOptionPane.ERROR_MESSAGE);
//        JOptionPane.showConfirmDialog(null, "Anas, do you even code?", "Anas", YES_NO_CANCEL_OPTION);
//        String anas = JOptionPane.showInputDialog("What's your name? ");
//        System.out.println("Hello "+ anas);
        JOptionPane.showOptionDialog(null, "You are awesome!", "secret message", YES_NO_CANCEL_OPTION, INFORMATION_MESSAGE, null, null, 0);
    }
}