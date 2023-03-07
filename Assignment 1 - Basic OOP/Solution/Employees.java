public class Employees {
    private String name;
    private String type;

    public Employees(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String GetType(){
        return type;
    }
    public String GetName(){
        return name;
    }
}
