package Server;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class clientHandler implements Runnable,Observer{
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;
    private int Id;
    private HashMap<String, Stock> stockList;


    public clientHandler(Socket client, int clientId, HashMap<String, Stock> stockList) throws IOException {
        this.client = client;
        this.Id = clientId;
        this.stockList = stockList;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(), true);

        System.out.println("Client "+Id+ " is logged in");
        printTheStockList();
    }

    public void printTheStockList(){
        output.println("All of the Stock list");
        output.flush();
        for (Map.Entry mapElement : stockList.entrySet()) {
            String key = (String) mapElement.getKey();
            Stock tmpStock = (Stock) mapElement.getValue();

            output.println("       "+tmpStock.getName() + " "+tmpStock.getStockCount()+ " "+tmpStock.getStockPrice());
            output.flush();
        }
    }

    @Override
    public void run() {
        while(true){
            try {
                String line = input.readLine();
                String tmp[] = line.split(" ");

                if(tmp[0].equalsIgnoreCase("S")){
                    Stock tmpStock = stockList.get(tmp[1]);
                    tmpStock.subscribe(this);
                    System.out.println("Client"+Id+" subscribed Stock "+ tmp[1]);
                    output.println("You subscribed Stock "+tmp[1]);
                    output.flush();
                }
                else if(tmp[0].equalsIgnoreCase("U")){
                    Stock tmpStock = stockList.get(tmp[1]);
                    tmpStock.unsubscribe(this);
                    System.out.println("Client"+Id+" unsubscribed Stock "+tmp[1]);
                    output.println("You unsubscribed Stock "+tmp[1]);
                    output.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void notify(String line) {
        output.println(line);
        output.flush();
    }
}
