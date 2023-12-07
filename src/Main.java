public class Main {
    public static void main(String[] args) throws BoxExeption {
     Box box1 = new Box<>();
      for (int i =0; i < 10; i++) {
         box1.add(new Apple(1.0f));
      }

      Box box2 = new Box<>();
      for (int i = 0; i<10; i++) {
          box2.add(new Orange(1.5f));
      }
      Box box3 = new Box<>();
        for (int i = 0; i<10; i++) {
            box3.add(new Orange(1.5f));
        }
      Box emptyBox = new Box();
      System.out.println("\n");

      System.out.println("Вес коробки №1 = "+ box1.getTotalWeight());
      System.out.println("Вес первой коробки №2 = "+ box2.getTotalWeight());
      System.out.println("Вес второй коробки №3 = "+ box3.getTotalWeight());
      System.out.println("\n");

      System.out.println(box1.compare(box2));
      System.out.println(box2.compare(box3));
      System.out.println("\n");

      box1.add(new Orange(1.5f));
      System.out.println("\n");

      box2.pureFromOneToAnother(box3);
      System.out.println(box2.getTotalWeight());
      System.out.println(box3.getTotalWeight());
      System.out.println("\n");

      box1.pureFromOneToAnother(box3);
      box3.pureFromOneToAnother(box2);
      System.out.println(box2.getTotalWeight());
      System.out.println("\n");

    }
}