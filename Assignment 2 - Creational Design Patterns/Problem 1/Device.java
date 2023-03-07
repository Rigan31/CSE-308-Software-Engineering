import Controller.Controller;
import Display.Display;
import Identification.Identification;
import InternetConnection.InternetConnection;
import Microcontroller.Microcontroller;
import Storage.Storage;
import Weight.Weight;
import Microcontroller.MicrocontrollerFactory;
import Weight.WeightFactory;
import Identification.IdentificationFactory;
import Storage.StorageFatory;
import Display.DisplayFactory;
import InternetConnection.InternetConnectionFactory;
import Controller.ControllerFactory;



public class Device implements DevicePlan{
    private Microcontroller microcontroller;
    private Weight weight;
    private Identification identification;
    private Storage storage;
    private Display display;
    private InternetConnection internetConnection;
    private Controller controller;

    @Override
    public void setMicrocontroller(String name) {
        MicrocontrollerFactory tmp = new MicrocontrollerFactory();
        microcontroller = tmp.getMicrocontroller(name);
    }

    public Microcontroller getMicrocontroller(){
        return microcontroller;
    }

    @Override
    public void setWeight(String name) {
        WeightFactory tmp = new WeightFactory();
        weight = tmp.getWeight(name);
    }

    public Weight getWeight(){
        return weight;
    }

    @Override
    public void setIdentification(String name) {
        IdentificationFactory tmp = new IdentificationFactory();
        identification = tmp.getIdentification(name);
    }

    public Identification getIdentification(){
        return identification;
    }

    @Override
    public void setStorage(String name) {
        StorageFatory tmp = new StorageFatory();
        storage = tmp.getStorage(name);
    }

    public Storage getStorage(){
        return storage;
    }

    @Override
    public void setDisplay(String name) {
        DisplayFactory tmp = new DisplayFactory();
        display = tmp.getDisplay(name);
    }

    public Display getDisplay(){
        return display;
    }
    @Override
    public void setInterntConnection(String name) {
        InternetConnectionFactory tmp = new InternetConnectionFactory();
        internetConnection = tmp.getInternetConnection(name);
    }

    public InternetConnection getInternetConnection(){
        return internetConnection;
    }
    @Override
    public void setController(String name) {
        ControllerFactory tmp = new ControllerFactory();
        controller = tmp.getController(name);
    }

    public Controller getController(){
        return controller;
    }
}
