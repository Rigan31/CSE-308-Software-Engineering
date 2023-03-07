import Aesthetics.Aesthetics;
import Aesthetics.Type1;

public class C_Parser implements Parser {
    @Override
    public Aesthetics getAesthetics() {
        return new Type1();
    }
}
