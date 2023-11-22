package DogsAndCats;

public class Animal {

    static int animalCount;

    public Animal() {
        animalCount++;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public void run(int distance) throws Exception {
        System.out.println("Животное пробежало " + distance);
    }

    public void swim(int distance)  {
        System.out.println("Животное проплыло " + distance);
    }
}
