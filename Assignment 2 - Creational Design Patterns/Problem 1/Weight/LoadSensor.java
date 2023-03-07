package Weight;

public class LoadSensor implements Weight {

    @Override
    public void measuredBy() {
        System.out.println("Weight Measurement: Load Sensor");
    }
}
