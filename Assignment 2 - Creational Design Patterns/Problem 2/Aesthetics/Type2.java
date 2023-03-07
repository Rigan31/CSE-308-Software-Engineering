package Aesthetics;

public class Type2 implements Aesthetics {
    @Override
    public void printFont() {
        System.out.println("Font: Monaco");
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
