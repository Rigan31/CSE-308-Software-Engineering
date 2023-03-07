import Internet.Internet;
import Internet.InternetFactory;
import WebServer.WebServer;
import WebServer.WebServerFactory;

public class TeaGAS {
    private Package hardware;
    private Internet internet;
    private WebServer server;

    public void setHardware(String name){
        Package tmp = new Package();
        tmp.createDevice(name);
        hardware = tmp;

    }

    public Package getHardware(){
        return hardware;
    }

    public void setInternet(String name){
        InternetFactory tmp = new InternetFactory();
        internet = tmp.getInternet(name);
    }

    public Internet getInternet(){
        return internet;
    }

    public void setServer(String name){
        WebServerFactory tmp = new WebServerFactory();
        server = tmp.getWebServer(name);
    }

    public WebServer getServer(){
        return server;
    }
}
