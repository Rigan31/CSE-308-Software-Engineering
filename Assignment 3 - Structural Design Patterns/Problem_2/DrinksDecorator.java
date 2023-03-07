abstract class DrinksDecorator implements Pizza {
    protected Pizza pizza;

    public DrinksDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    public String getDescription(){
        return pizza.getDescription();
    }

    public double getCost(){
        return pizza.getCost();
    }
}
