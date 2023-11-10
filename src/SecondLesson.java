public class SecondLesson {

    public static void main(String[] args) {
        SecondLesson task1 = new SecondLesson();
        task1.printThreeWords();
        task1.checkSumSign();
        task1.printColor();
        task1.compareNumbers();
    }

    public void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public void checkSumSign() {
        int a = -12;
        int b = 10;
        if (a+b>=0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public void printColor() {
       int value = 84;
       if (value<=0) {
           System.out.println("Красный");
        } else if (value>0 && value<=100) {
           System.out.println("Желтый");
        } else {
           System.out.println("Зеленый");
       }
           }

    public void compareNumbers() {
        int a = 21;
        int b = 20;
        if (a>=b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }

    }
}
