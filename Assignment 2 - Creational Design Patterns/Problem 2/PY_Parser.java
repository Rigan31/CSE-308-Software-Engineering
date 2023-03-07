import Aesthetics.Aesthetics;
import Aesthetics.Type3;

public class PY_Parser implements Parser {
    @Override
    public Aesthetics getAesthetics() {
        return new Type3();
    }
}
