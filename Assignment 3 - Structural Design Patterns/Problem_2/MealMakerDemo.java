import sun.java2d.loops.FillRect;

import java.util.Scanner;

public class MealMakerDemo {
    public static void main(String []args){

        while(true){
            System.out.println("=================Menu====================");
            System.out.println("1. Beef Pizza with French Fry");
            System.out.println("2. Veggi Pizza with onion rings");
            System.out.println("3. A combo meal with Veggi Pizza, French Fry and Coke");
            System.out.println("4. A combo meal with Veggi Pizza, Onion Rings and Coffee");
            System.out.println("5. A Beef Pizza only");
            System.out.println("6. Exit");


            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            Pizza newPizza;
            if(choice == 1){
                newPizza = new FrenchFries(new BeefPizza());
            }
            else if(choice == 2){
                newPizza = new OnionRings(new VeggiPizza());
            }
            else if(choice == 3){
                newPizza = new Coke(new FrenchFries(new VeggiPizza()));
            }
            else if(choice == 4){
                newPizza = new OnionRings(new Coffee(new VeggiPizza()));
            }
            else if(choice == 5){
                newPizza = new BeefPizza();
            }
            else{
                return;
            }

            System.out.println("Description: "+newPizza.getDescription());
            System.out.println("Total Cost: "+newPizza.getCost());
        }



    }
}
