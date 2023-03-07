package InternetConnection;

public class Wifi_GSM implements InternetConnection {
    @Override
    public void availableConnection() {
        System.out.println("Internet Connection available: Wifi and GSM");
    }
}
