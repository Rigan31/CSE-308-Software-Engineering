package WebServer;

public class WebServerFactory {
    public WebServer getWebServer(String name){
        if(name.equalsIgnoreCase("Django")){
            return new Django();
        }
        else if(name.equalsIgnoreCase("Spring")){
            return new Spring();
        }
        else if(name.equalsIgnoreCase("Laravel")){
            return new Laravel();
        }
        else{
            return null;
        }

    }
}
