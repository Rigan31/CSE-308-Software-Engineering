import java.io.FileNotFoundException;

public class SumAdapter implements Sum{
    AsciiSum asciiSum;

    public SumAdapter(){
        asciiSum = new CharacterSum();
    }

    @Override
    public void calculateSum(String type, String filename) {
        try {
            asciiSum.calculateSum(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
