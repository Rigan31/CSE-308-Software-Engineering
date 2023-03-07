package Storage;

public class StorageFatory {
    public Storage getStorage(String name){
        if(name.equalsIgnoreCase("ATMega32")){
            return new SdStorage();
        }
        else if(name.equalsIgnoreCase("Arduino")){
            return new SdStorage();
        }
        else if(name.equalsIgnoreCase("Raspberry Pi")){
            return new InternanStorage();
        }
        else{
            return null;
        }
    }
}
