package Client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
    final static int PORT = 4999;
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", PORT);

        PrintWriter output = new PrintWriter(client.getOutputStream(), true);
        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        BufferedReader input = new BufferedReader(isr);

        Scanner sc = new Scanner(System.in);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    String line = sc.nextLine();
                    output.println(line);
                    output.flush();
                }
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        String line = input.readLine();
                        System.out.println(line);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
    }

}
