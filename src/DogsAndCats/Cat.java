package DogsAndCats;

import DogsAndCats.Animal;

public class Cat extends Animal {
    String name;
    int appetite;
    boolean hungry;
    static int catCount;

    public Cat (String name) {
        this.name = name;
        catCount++;

    }
    public Cat (String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    public void info() {
        String isHungry = !hungry ? "сыт" : "голоден";
        System.out.println(name + ": " + isHungry);
    }

    public void eat(Plate plate) {
        if (hungry && plate.removeFood(appetite))
            hungry = false;
    }

    public static int getCatCount() {
        return catCount;
    }

    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void run(int distance) {
        if (distance<0) {
            System.out.println("Нельзя пробежать отрицательное число метров");
        }
        else if ((distance>0) && (distance<=200)) {
            System.out.println("Кошка " + name + " пробежала " + distance);
        } else {
            System.out.println("Кошки столько не могут пробежать");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умеют плавать");
    }
}
