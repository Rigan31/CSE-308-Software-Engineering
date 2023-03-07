package Microcontroller;

public class MicrocontrollerFactory {
    public Microcontroller getMicrocontroller(String name){
        if(name.equalsIgnoreCase("ATMega32")){
            return new ATMega32();
        }
        else if(name.equalsIgnoreCase("Arduino")){
            return new Arduino();
        }
        else if(name.equalsIgnoreCase("Raspberry Pi")){
            return new RaspberryPi();
        }
        else{
            return null;
        }
    }
}
