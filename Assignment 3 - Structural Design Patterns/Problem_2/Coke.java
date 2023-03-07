public class Coke extends DrinksDecorator {
    public Coke(Pizza pizza) {
        super(pizza);
    }

    public String getDescription(){
        return pizza.getDescription() + " with Coke";
    }

    public double getCost(){
        return pizza.getCost()+25.00;
    }
}
