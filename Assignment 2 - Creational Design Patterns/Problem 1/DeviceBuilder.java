public class DeviceBuilder {
    private Device device;

    DeviceBuilder(){
        this.device = new Device();
    }

    public void buildDevice(String microController, String weight){
        device.setMicrocontroller(microController);
        device.setWeight(weight);
        device.setIdentification(microController);
        device.setStorage(microController);
        device.setDisplay(microController);
        device.setInterntConnection(microController);
        device.setController(microController);
    }

    public Device getDevice(){
        return device;
    }

    public void show(){
        device.getMicrocontroller().printMicrocontroller();
        device.getWeight().measuredBy();
        device.getIdentification().card();
        device.getStorage().storageSystem();
        device.getDisplay().printScreen();
        device.getInternetConnection().availableConnection();
        device.getController().printController();
    }
}
