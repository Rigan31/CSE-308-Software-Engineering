import java.util.Scanner;

public class mainClass {

    public static void main(String[] args){
        TeaGASBuilder builder = new TeaGASBuilder();

        System.out.println("Package:");
        System.out.println("1.Silver ------- ATMega32 with load sensor");
        System.out.println("2.Gold ------- Arduino with weight module");
        System.out.println("3.Diamond ------- Raspberry Pi with load sensor");
        System.out.println("4.Platinum ------- Raspberry Pi with weight module");

        System.out.println("Which package will you like to choose?");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        builder.buildHardware(input);
        builder.showHardware();


        System.out.println();
        System.out.println();
        System.out.println("Which internet connection will you like to choose?");

        input = sc.nextLine();
        builder.buildInternet(input);
        builder.showInternet();

        System.out.println();
        System.out.println();
        System.out.println("Web Server");
        System.out.println("1.Django");
        System.out.println("2.Spring");
        System.out.println("3. Laravel");

        System.out.println("Which server will you like to choose?");

        input = sc.nextLine();
        builder.buildServer(input);
        builder.showServer();
    }
}
