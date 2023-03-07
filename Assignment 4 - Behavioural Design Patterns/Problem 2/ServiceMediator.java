import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ServiceMediator implements Mediator {

    private String mediatorName;
    private ArrayList<Organization> listOfOrganization;
    private Queue<String> water;
    private Queue<String> energy;
    private Queue<String> transport;
    private Queue<String> telecom;

    public ServiceMediator(String name){
        mediatorName = name;
        water = new LinkedList<>();
        energy = new LinkedList<>();
        transport = new LinkedList<>();
        telecom = new LinkedList<>();
        listOfOrganization = new ArrayList<>();
    }

    public void addServiceProvider(Organization provider){
        listOfOrganization.add(provider);
    }

    public String whatService(String name){
        for(Organization tmp: listOfOrganization){
            if(tmp.getName().equalsIgnoreCase(name)){
                return tmp.getTypeOfService();
            }
        }
        return null;
    }
    @Override
    public void waterRequest(String name) {
        water.add(name);
        System.out.println(name+ " requests for WATER service");
    }

    @Override
    public void energyRequest(String name) {
        energy.add(name);
        System.out.println(name+ " requests for ENERGY service");
    }

    @Override
    public void transportRequest(String name) {
        transport.add(name);
        System.out.println(name+ " requests for TRANSPORT service");
    }

    @Override
    public void telecomRequest(String name) {
        telecom.add(name);
        System.out.println(name+ " requests for TELECOM service");
    }

    @Override
    public void serveRequest(String name) {
        String typeOfService = whatService(name);
        if(typeOfService == null) return;
        if(typeOfService.equalsIgnoreCase("WATER")){
            if(water.isEmpty()){
                System.out.println("There is no request left");
                return;
            }
            String serviceTaker = water.remove();
            System.out.println(name + " serves the request of " + serviceTaker);
        }
        else if(typeOfService.equalsIgnoreCase("ENERGY")){
            if(energy.isEmpty()){
                System.out.println("There is no request left");
                return;
            }
            String serviceTaker = energy.remove();
            System.out.println(name + " serves the request of " + serviceTaker);
        }
        else if(typeOfService.equalsIgnoreCase("TRANSPORT")){
            if(transport.isEmpty()){
                System.out.println("There is no request left");
                return;
            }
            String serviceTaker = transport.remove();
            System.out.println(name + " serves the request of " + serviceTaker);
        }
        else if(typeOfService.equalsIgnoreCase("TELECOM")){
            if(telecom.isEmpty()){
                System.out.println("There is no request left");
                return;
            }
            String serviceTaker = telecom.remove();
            System.out.println(name + " serves the request of " + serviceTaker);
        }
    }
}
