import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        try {
            FileWriter writer = new FileWriter("poem.txt");
            writer.write("Roses are red \nBooty booty booty \nRockin everywhere!");
            writer.append("\n(a poem by Anas)");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}