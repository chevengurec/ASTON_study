package Figures;

import Figures.Figure;

public class Triangle implements Figure {

    private double a;
    private double b;
    private double c;
    private String colourArea;
    private String colourPerimeter;

    public Triangle(double a, double b, double c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public Triangle(double a, double b, double c, String colourArea, String colourPerimeter) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
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
        return a+b+c;
    }

    @Override
    public double area() {
        double p = (a+b+c)/2.0;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }


}

