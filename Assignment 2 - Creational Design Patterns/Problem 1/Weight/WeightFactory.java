package Weight;

public class WeightFactory {
    public Weight getWeight(String name){
        if(name.equalsIgnoreCase("load sensor")){
            return new LoadSensor();
        }
        else if(name.equalsIgnoreCase("weight module")){
            return new WeightModule();
        }
        else{
            return null;
        }
    }
}
