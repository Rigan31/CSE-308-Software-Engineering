package InternetConnection;

public class Wifi_GSM_Ethernet implements InternetConnection {
    @Override
    public void availableConnection() {
        System.out.println("Internet Connection available: Wifi, GSM and Ethernet");
    }
}
