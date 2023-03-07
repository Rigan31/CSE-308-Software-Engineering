import java.util.Scanner;

public class mainClass {
    public static void main(String[] args){

        System.out.print("Enter the Filename: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();


        mainDemo demo = new mainDemo();
        demo.setParser(input);
        demo.show();

    }
}
