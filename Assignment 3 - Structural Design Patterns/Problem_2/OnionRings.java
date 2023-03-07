public class OnionRings extends AppetizerDecorator {
    public OnionRings(Pizza pizza) {
        super(pizza);
    }

    public String getDescription(){
        return pizza.getDescription() + " with Onion Rings";
    }

    public double getCost(){
        return pizza.getCost()+100.00;
    }
}
