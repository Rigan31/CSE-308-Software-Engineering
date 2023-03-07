import java.util.Scanner;

public class MediatorPatternDemo {
    public static void main(String[] args){
        ServiceMediator JCC = null;
        WaterServices JWSA = null;
        EnergyServices JPDC = null;
        TransportServices JRTA = null;
        TelecomServices JTRC = null;

        while(true){
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            String tmp[] = line.split(" ");

            if(line.equalsIgnoreCase("END")){
                break;
            }
            else if(line.equalsIgnoreCase("Init")){
                JCC = new ServiceMediator("JCC");
                JWSA = new WaterServices(JCC, "JWSA");
                JPDC = new EnergyServices(JCC, "JPDC");
                JRTA = new TransportServices(JCC, "JRTA");
                JTRC = new TelecomServices(JCC, "JTRC");

                JCC.addServiceProvider(JWSA);
                JCC.addServiceProvider(JPDC);
                JCC.addServiceProvider(JRTA);
                JCC.addServiceProvider(JTRC);

                System.out.println("All four services are initiated through mediator");
            }
            else if(tmp[1].equalsIgnoreCase("WATER")){
                JCC.waterRequest(tmp[0]);
            }
            else if(tmp[1].equalsIgnoreCase("ENERGY")){
                JCC.energyRequest(tmp[0]);
            }
            else if(tmp[1].equalsIgnoreCase("TRANSPORT")){
                JCC.transportRequest(tmp[0]);
            }
            else if(tmp[1].equalsIgnoreCase("TELECOM")) {
                JCC.telecomRequest(tmp[0]);
            }
            else if(tmp[1].equalsIgnoreCase("SERVE")){
                JCC.serveRequest(tmp[0]);
            }
        }
    }
}
