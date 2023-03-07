import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CalculateSumDemo {
    public static void main(String []args) throws IOException {
        IntegerSum is = new IntegerSum();

        System.out.print("Enter the type of file and filename: ");
        System.out.println();

        Scanner sc= new Scanner(System.in);
        String data = sc.nextLine();
        String tokens[] = data.split(" ");
        is.calculateSum(tokens[0], tokens[1]);

    }
}
