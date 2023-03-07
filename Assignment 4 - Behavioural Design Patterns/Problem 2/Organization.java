public abstract class Organization {
    private Mediator mediator;
    private String name;
    private String typeOfService;

    public Organization(Mediator mediator, String name, String type){
        this.mediator = mediator;
        this.name = name;
        this.typeOfService = type;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getTypeOfService(){
        return typeOfService;
    }
    public void waterRequest(){
        mediator.waterRequest(name);
    }

    public void energyRequest(){
        mediator.energyRequest(name);
    }

    public void transportRequest(){
        mediator.transportRequest(name);
    }

    public void telecomRequest(){
        mediator.telecomRequest(name);
    }

    public void serveRequest(){
        mediator.serveRequest(name);
    }
}
