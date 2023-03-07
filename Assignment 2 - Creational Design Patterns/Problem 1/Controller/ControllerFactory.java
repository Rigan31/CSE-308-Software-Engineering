package Controller;

public class ControllerFactory {
    public Controller getController(String name){
        if(name.equalsIgnoreCase("ATMega32")){
            return new Buttons();
        }
        else if(name.equalsIgnoreCase("Arduino")){
            return new Buttons();
        }
        else if(name.equalsIgnoreCase("Raspberry Pi")){
            return new TouchScreen();
        }
        else{
            return null;
        }
    }
}
