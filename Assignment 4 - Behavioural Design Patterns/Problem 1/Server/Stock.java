package Server;

import java.util.ArrayList;

public class Stock implements Subject{
    private String stockName;
    private int stockCount;
    private float stockPrice;
    private ArrayList<Observer> subscriberList;

    public Stock(String name, int count, float price){
        this.stockName = name;
        this.stockCount = count;
        this.stockPrice = price;
        subscriberList = new ArrayList<>();
    }

    public String getName(){
        return stockName;
    }
    public void changeStockCount(int count){
        String msg = "Stock count of Product: " + this.stockName + " changes from " + this.stockCount + " to " + count;
        this.stockCount = count;
        System.out.println(msg);
        notifyAllTheObserver(msg);
    }

    public int getStockCount(){
        return this.stockCount;
    }

    public void increasePrice(float price){
        float tmp = this.stockPrice;
        this.stockPrice += price;

        String msg = "Stock price of Product: " + this.stockName + " increases from " + tmp + " to " + this.stockPrice;
        System.out.println(msg);
        notifyAllTheObserver(msg);
    }

    public void decreasePrice(float price){
        float tmp = this.stockPrice;
        this.stockPrice -= price;
        if(this.stockPrice < 0.0){
            this.stockPrice = 0;
        }

        String msg = "Stock price of Product: " + this.stockName + " decreases from " + tmp + " to " + this.stockPrice;
        System.out.println(msg);
        notifyAllTheObserver(msg);
    }

    public float getStockPrice(){
        return this.stockPrice;
    }

    @Override
    public void subscribe(Observer observer){
        subscriberList.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer){
        int observerIndex = subscriberList.indexOf(observer);
        subscriberList.remove(observerIndex);
    }

    @Override
    public void notifyAllTheObserver(String msg){
        for(Observer observer : subscriberList){
            observer.notify(msg);
        }
    }


}
