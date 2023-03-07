public class VeggiPizza implements  Pizza {
    @Override
    public String getDescription() {
        return "Veggi Pizza";
    }

    @Override
    public double getCost() {
        return 80.00;
    }
}
