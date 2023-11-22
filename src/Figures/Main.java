package Figures;

public class Main {
    public static void main(String[] args) {
        Rectangle rect=new Rectangle(10,5, "Красный", "Черный");
        Circle circle=new Circle(4, "Белый","Черный");
        Triangle triangle =new Triangle(5,6,7,"Зеленый","Черный");

        System.out.println("Периметр прямоугольника со сторонами " + rect.getA() + " и " + rect.getB() + " равен " + rect.perimeter());
        System.out.println("Площадь прямоугольника со сторонами " + rect.getA() + " и " + rect.getB() + " равна " + rect.area());
        System.out.println("Цвет заливки прямоугольника " + rect.getColourArea() + ", цвет границ " + rect.getColourPerimeter());
        System.out.println("\n");

        System.out.println("Длина окружности круга с радиусом " + circle.getR() + " равна " + circle.perimeter());
        System.out.println("Площадь круга с радиусом " + circle.getR() + " равна " + circle.area());
        System.out.println("Цвет заливки круга " + circle.getColourArea() + ", цвет границ " + circle.getColourPerimeter());
        System.out.println("\n");

        System.out.println("Периметр треугольника со сторонами " + triangle.getA() + " и " + triangle.getB() + " и " + triangle.getC() + " равен " + triangle.perimeter());
        System.out.println("Площадь треугольника со сторонами " + triangle.getA() + " и " + triangle.getB() + " и " + triangle.getC() + " равна " + triangle.area());
        System.out.println("Цвет заливки треугольника " + triangle.getColourArea() + ", цвет границ " + triangle.getColourPerimeter());
        System.out.println("\n");
    }
}
