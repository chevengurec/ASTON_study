package DogsAndCats;

public class Main {
    public static void main(String[] args) throws Exception {
     
     Animal dog1 = new Dog("Bobik");
     dog1.run(100);

     Animal cat1 = new Cat("Pusia");
     cat1.run(100);

     Animal cat2 = new Cat("Dusia");
     cat2.run(1000);

     Animal dog2 = new Dog("Sharik");
     dog2.run(-10);

     Animal cat3 = new Cat("Murka");
     cat3.swim(10);

     System.out.println("\n");
     System.out.println("В соревнованиях участвовали " + Animal.getAnimalCount() + " животных. В том числе: ");
     System.out.println(Cat.getCatCount() + " кошек");
     System.out.println(Dog.getDogCount() + " собак");

     System.out.println("\n");
     Cat[] cats = {new Cat("Musia", 60),
             new Cat("Bandit", 50),
             new Cat("Barsik", 25),
             new Cat("Kissi", 5)};

     Plate plate = new Plate( 80);

     for (Cat cat : cats) {
      cat.eat(plate);
      cat.info();
     }
     System.out.println("\n");


    }
}