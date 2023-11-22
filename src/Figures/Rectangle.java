package Figures;

import Figures.Figure;

public class Rectangle implements Figure {

    private double  a;
    private double  b;
    private String colourArea;
    private String colourPerimeter;

    public Rectangle(double a,double b) {
        this.a=a;
        this.b=b;
    }

    public Rectangle(double a, double b, String colourArea, String colourPerimeter) {
        this.a = a;
        this.b = b;
        this.colourArea = colourArea;
        this.colourPerimeter = colourPerimeter;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
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

    public double perimeter() {
        return 2*(a+b);
    }
    public double area() {
        return a*b;
    }

}
