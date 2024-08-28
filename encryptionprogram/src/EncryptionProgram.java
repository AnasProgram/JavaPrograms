import java.util.*;

public class EncryptionProgram
{
    private Scanner scanner;
    private Random random;
    private ArrayList<Character> arrayList;
    private ArrayList<Character> arrayList1;
    private  char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;

    EncryptionProgram()
    {
        scanner = new Scanner(System.in);
        random = new Random();
        arrayList = new ArrayList<>();
        arrayList1 = new ArrayList<>();
        character = ' ';

        newKey();
        askQuestion();
    }
    private void askQuestion()
    {
        while (true)
        {
            System.out.println("**************************************************");
            System.out.println("What you want to do?");
            System.out.println("(N)ewKey, (G)etKey, (E)ncrypt, (D)ecrypt, (Q)uit");
            char response = Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response)
            {
                case  'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                    break;
                default:
                    System.out.println("Not a valid answer :(");
            }
        }
    }
    private void newKey()
    {
        character = ' ';
        arrayList.clear();
        arrayList1.clear();

        for(int i = 32; i < 127;i++)
        {
            arrayList.add(Character.valueOf(character));
            character++;
        }
        arrayList1 = new ArrayList(arrayList);
        Collections.shuffle(arrayList1);
        System.out.println("A new key has been generated");
    }
    private void getKey()
    {
        System.out.println("Key: ");
        for(Character x : arrayList)
        {
            System.out.println(x);
        }
        System.out.println();
        for (Character x : arrayList1)
        {
            System.out.println(x);
        }
        System.out.println();
    }
    private void encrypt()
    {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++)
        {
            for (int j = 0; j < arrayList.size(); j++)
            {
                if (letters[i] == arrayList.get(j))
                {
                    letters[i] = arrayList1.get(j);
                    break;
                }
            }
        }
        System.out.println("Encrypted: ");
        for (char x :letters)
        {
            System.out.println(x);
        }
        System.out.println();
    }
    private void decrypt()
    {
        System.out.println("Enter a message to be dencrypted: ");
        String message = scanner.nextLine();

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++)
        {
            for (int j = 0; j < arrayList1.size(); j++)
            {
                if (letters[i] == arrayList1.get(j))
                {
                    letters[i] = arrayList.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted: ");
        for (char x :letters)
        {
            System.out.println(x);
        }
        System.out.println();
    }
    private void quit()
    {
        System.out.println("Thanl you and have a nice day!");
        System.exit(0);
    }
}
