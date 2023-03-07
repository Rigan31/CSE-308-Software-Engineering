package Aesthetics;

public class Type3 implements Aesthetics {
    @Override
    public void printFont() {
        System.out.println("Font: Consolas");
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
