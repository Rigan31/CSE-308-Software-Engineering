public class FrenchFries extends AppetizerDecorator {
    public FrenchFries(Pizza pizza) {
        super(pizza);
    }

    public String getDescription(){
        return pizza.getDescription() + " with French Fry";
    }

    public double getCost(){
        return pizza.getCost()+100.00;
    }
}
