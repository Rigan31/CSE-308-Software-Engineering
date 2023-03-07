package Internet;

public class InternetFactory {
    public Internet getInternet(String name){
        if(name.equalsIgnoreCase("Wifi")){
            return new Wifi();
        }
        else if(name.equalsIgnoreCase("Ethernet")){
            return new Ethernet();
        }
        else if(name.equalsIgnoreCase("GSM")){
            return new GSM();
        }
        else{
            return null;
        }
    }
}
