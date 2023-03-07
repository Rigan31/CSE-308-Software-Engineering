import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntegerSum implements Sum {
    SumAdapter sumAdapter;

    @Override
    public void calculateSum(String type, String filename) throws FileNotFoundException {
        int sum;
        if(type.equalsIgnoreCase("integer")){
            File myfile = new File(filename);

            Scanner sc = new Scanner(myfile);

            sum = 0;
            while(sc.hasNextLine()){
                String data = sc.nextLine();
                String tokens[] = data.split(" ");

                for(String tmp : tokens){
                    sum += Integer.parseInt(tmp);

                }
            }
            sc.close();

            System.out.println("Total Sum: "+ sum);
        }
        else{
            sumAdapter = new SumAdapter();
            sumAdapter.calculateSum(type, filename);
        }
    }
}
