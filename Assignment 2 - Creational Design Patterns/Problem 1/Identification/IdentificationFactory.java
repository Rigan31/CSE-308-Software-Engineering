package Identification;

public class IdentificationFactory {
    public Identification getIdentification(String name){
        if(name.equalsIgnoreCase("ATMega32")){
            return new RFIDcard();
        }
        else if(name.equalsIgnoreCase("Arduino")){
            return new RFIDcard();
        }
        else if(name.equalsIgnoreCase("Raspberry Pi")){
            return new NFCcard();
        }
        else{
            return null;
        }
    }
}
