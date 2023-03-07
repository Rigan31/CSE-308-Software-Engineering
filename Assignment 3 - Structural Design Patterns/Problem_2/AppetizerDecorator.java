abstract class AppetizerDecorator implements Pizza{
    protected Pizza pizza;

    public AppetizerDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    public String getDescription(){
        return pizza.getDescription();
    }

    public double getCost(){
        return pizza.getCost();
    }
}
