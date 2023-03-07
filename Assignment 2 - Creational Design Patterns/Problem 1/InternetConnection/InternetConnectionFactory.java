package InternetConnection;

public class InternetConnectionFactory {
    public InternetConnection getInternetConnection(String name){
        if(name.equalsIgnoreCase("ATMega32")){
            return new Wifi_GSM();
        }
        else if(name.equalsIgnoreCase("Arduino")){
            return new Wifi_GSM();
        }
        else if(name.equalsIgnoreCase("Raspberry Pi")){
            return new Wifi_GSM_Ethernet();
        }
        else{
            return null;
        }
    }
}
