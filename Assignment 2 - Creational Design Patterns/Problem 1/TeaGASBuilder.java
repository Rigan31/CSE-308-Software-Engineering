public class TeaGASBuilder {
    private TeaGAS teaGAS;

    TeaGASBuilder(){
        this.teaGAS = new TeaGAS();
    }

    public void buildHardware(String PackageName){
        teaGAS.setHardware(PackageName);
    }

    public void showHardware(){
        teaGAS.getHardware().show();
    }

    public void buildInternet(String internet){
        teaGAS.setInternet(internet);
    }

    public void showInternet(){
        teaGAS.getInternet().printInternet();
    }

    public void buildServer(String server){
        teaGAS.setServer(server);
    }

    public void showServer(){
        teaGAS.getServer().printServer();
    }
}
