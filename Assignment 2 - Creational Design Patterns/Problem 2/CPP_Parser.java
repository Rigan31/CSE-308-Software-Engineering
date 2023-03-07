import Aesthetics.Aesthetics;
import Aesthetics.Type2;
public class CPP_Parser implements Parser {
    @Override
    public Aesthetics getAesthetics() {
        return new Type2();
    }
}
