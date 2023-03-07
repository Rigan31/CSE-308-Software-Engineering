package Aesthetics;

public class Type1 implements Aesthetics{

    @Override
    public void printFont() {
        System.out.println("Font: Courier New");
    }

    @Override
    public void printStyle() {
        System.out.println("Style: Normal");
    }

    @Override
    public void printColor() {
        System.out.println("Color: Blue");
    }
}
