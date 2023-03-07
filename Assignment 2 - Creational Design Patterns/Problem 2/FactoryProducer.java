public class FactoryProducer  {
    public static Parser getParser(String name){
        if(name.equalsIgnoreCase("C")){
            return new C_Parser();
        }
        else if(name.equalsIgnoreCase("CPP")){
            return new CPP_Parser();
        }
        else if(name.equalsIgnoreCase("PY")){
            return new PY_Parser();
        }
        else{
            return null;
        }
    }
}
