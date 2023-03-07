package Server;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class server {
    final static int PORT = 4999;
    private static HashMap<Integer, clientHandler> listOfClient = new HashMap<Integer, clientHandler>();
    private static HashMap<String, Stock> stockList = new HashMap<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    private static int clientCounter = 1;

    public static void readTheStockFile() throws FileNotFoundException {
        File myObj = new File("input.txt");
        Scanner sc = new Scanner(myObj);

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String sep[] = line.split(" ");

            Stock stock = new Stock(sep[0], Integer.parseInt(sep[1]), Float.parseFloat(sep[2]));
            stockList.put(sep[0], stock);
        }

    }


    public static void StartServer(ServerSocket ss) throws IOException {
        System.out.println("Server created");
        readTheStockFile();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    Socket clientSocket = null;
                    try {
                        clientSocket = ss.accept();
                        clientHandler client = new clientHandler(clientSocket, clientCounter, stockList);
                        listOfClient.put(clientCounter, client);
                        clientCounter++;
                        pool.execute(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner sc = new Scanner(System.in);
                while(true){
                    String line = sc.nextLine();
                    String tmp[] = line.split(" ");
                    if(tmp[0].equalsIgnoreCase("I")){
                        Stock tmpStock = stockList.get(tmp[1]);
                        tmpStock.increasePrice(Float.parseFloat(tmp[2]));
                    }
                    else if(tmp[0].equalsIgnoreCase("D")){
                        Stock tmpStock = stockList.get(tmp[1]);
                        tmpStock.decreasePrice(Float.parseFloat(tmp[2]));
                    }
                    else if(tmp[0].equalsIgnoreCase("C")){
                        Stock tmpStock = stockList.get(tmp[1]);
                        tmpStock.changeStockCount(Integer.parseInt(tmp[2]));
                    }
                }
            }
        });
        t2.start();

    }


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(PORT);
        StartServer(ss);
    }

}
