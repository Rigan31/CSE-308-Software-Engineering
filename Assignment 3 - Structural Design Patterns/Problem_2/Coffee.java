public class Coffee extends DrinksDecorator {
    public Coffee(Pizza pizza) {
        super(pizza);
    }

    public String getDescription(){
        return pizza.getDescription() + " with Coffee";
    }

    public double getCost(){
        return pizza.getCost()+100;
    }
}
