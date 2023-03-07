import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharacterSum implements AsciiSum {
    @Override
    public void calculateSum(String filename) throws FileNotFoundException {
        File myfile = new File(filename);
        Scanner sc = new Scanner(myfile);

        int asciiValue = 0;
        while(sc.hasNextLine()){
            String data = sc.nextLine();
            String tokens[] = data.split(" ");
            for(String token: tokens){
                asciiValue += token.charAt(0);
            }
        }

        System.out.println("Total Ascii Sum: "+ asciiValue);
    }
}
