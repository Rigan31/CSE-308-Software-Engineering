public class BeefPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Beef Pizza";
    }

    @Override
    public double getCost() {
        return 100.00;
    }
}
