package Display;

public class DisplayFactory {
    public Display getDisplay(String name){
        if(name.equalsIgnoreCase("ATMega32")){
            return new LcdDisplay();
        }
        else if(name.equalsIgnoreCase("Arduino")){
            return new LedDisplay();
        }
        else if(name.equalsIgnoreCase("Raspberry Pi")){
            return new TouchDisplay();
        }
        else{
            return null;
        }
    }
}
