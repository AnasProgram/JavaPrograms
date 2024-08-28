import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        try {
            FileReader fileReader = new FileReader("art.txt");
            try
            {
                int data = fileReader.read();
                while(data != -1)
                {
                    System.out.print((char) data);
                    data = fileReader.read();
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }
}