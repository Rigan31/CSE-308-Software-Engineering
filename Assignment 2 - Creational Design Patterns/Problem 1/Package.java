public class Package {
    private DeviceBuilder hardwareDevice;

    Package(){
        this.hardwareDevice = new DeviceBuilder();
    }
    public void createDevice(String name){
        String microcontroller;
        String weight;
        if(name.equalsIgnoreCase("Silver")){
            microcontroller = "ATMega32";
            weight = "load sensor";
        }
        else if(name.equalsIgnoreCase("Gold")){
            microcontroller = "Arduino";
            weight = "weight module";
        }
        else if(name.equalsIgnoreCase("Diamond")){
            microcontroller = "Raspberry Pi";
            weight = "load sensor";
        }
        else if(name.equalsIgnoreCase("Platinum")){
            microcontroller = "Raspberry Pi";
            weight = "weight module";
        }
        else{
            microcontroller = "";
            weight = "";
        }

        hardwareDevice.buildDevice(microcontroller, weight);
    }

    public void show(){
        hardwareDevice.show();
    }
}
