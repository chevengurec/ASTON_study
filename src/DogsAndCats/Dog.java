package DogsAndCats;

import DogsAndCats.Animal;

public class Dog extends Animal {
    String name;
    static int dogCount;
    public Dog(String name) {
        this.name = name;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public void run(int distance) {

        if (distance < 0) {
            System.out.println("Нельзя пробежать отрицательное число метров");
        } else if ((distance > 0) && (distance <= 500)) {
            System.out.println("Собака " + name + " пробежала " + distance);
        } else {
            System.out.println("Собаки столько не могут пробежать");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance < 0) {
            System.out.println("Нельзя проплыть отрицательное число метров");
        } else if ((distance > 0) && (distance <= 10)) {
            System.out.println("Собака " + name + " проплыла " + distance);
        } else {
            System.out.println("Собаки столько не могут проплыть");
        }
    }
}