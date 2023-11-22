package Figures;

public class Circle implements Figure {
    private double r;
    private String colourArea;
    private String colourPerimeter;
    public  Circle(double r) {
        this.r = r;
    }

    public Circle(double r, String colourArea, String colourPerimeter) {
        this.r = r;
        this.colourArea = colourArea;
        this.colourPerimeter = colourPerimeter;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getColourArea() {
        return colourArea;
    }

    public void setColourArea(String colourArea) {
        this.colourArea = colourArea;
    }

    public String getColourPerimeter() {
        return colourPerimeter;
    }

    public void setColourPerimeter(String colourPerimeter) {
        this.colourPerimeter = colourPerimeter;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*r;
    }

    @Override
    public double area() {
        return Math.PI*r*r;
    }

}
