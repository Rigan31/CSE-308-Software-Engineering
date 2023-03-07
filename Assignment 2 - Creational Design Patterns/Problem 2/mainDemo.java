public class mainDemo {
    private Parser parser;

    public void setParser(String input){
        String[] tokens = input.split("[.]");
        parser = FactoryProducer.getParser(tokens[1]);

    }

    public void show(){
        parser.getAesthetics().printColor();
        parser.getAesthetics().printFont();
        parser.getAesthetics().printStyle();
    }
}
