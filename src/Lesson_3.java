import java.lang.reflect.Array;
import java.util.Arrays;

public class Lesson_3 {
    public static void main(String[] args) {

        Lesson_3 task = new Lesson_3();
        boolean b = task.twoNumbersSum(3,7);
        System.out.println(b);

        task.printString("Зимы не будет", 5);

        task.positivOrNegativ(1);

        boolean c = task.moreOrLessThenZero(-10);
        System.out.println(c);

        boolean year = task.leapYear(2012);
        System.out.println(year);

        int[] array = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        int[] reverseArray = task.reverseZeroAndOne(array);
        System.out.println(Arrays.toString(reverseArray));

        int[] array2 = new int[100];
        int[] array3 = task.fillTheArray(array2);
        System.out.println(Arrays.toString(array3));

        int[] array4 = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[] array5 = task.multiArr(array4);
        System.out.println(Arrays.toString(array5));

        int[][] array6 = new int [10][10];
        int[][] array7 = task.arrDouble(array6);
        for (int[] ints : array7) {
            for (int j = 0; j < array7[0].length; j++) {
                System.out.print(" " + ints[j] + " ");
            }
            System.out.println();
        }

        int[] array8 = task.returnArr(5,4);
        System.out.println(Arrays.toString(array8));

    }

    /*
    1.Написать метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20
(включительно), если да – вернуть true, в противном случае – false.
     */
    public boolean twoNumbersSum (int a, int b) {
        int sum = a+b;
        return (sum>=10 && sum <=20);
    }

    /*
    2. Написать метод, которому в качестве аргументов передается строка и число,
     метод должен отпечатать в консоль указанную строку, указанное количество раз;
     */
    public void printString (String s, int a) {
        for (int i = 0;  i < a; i++) {
            System.out.println(s);
        }
        }

        /*
        3. Написать метод, которому в качестве параметра передается целое число,
        метод должен напечатать в консоль,
         положительное ли число передали или отрицательное.
         Замечание: ноль считаем положительным числом.
         */
    public void positivOrNegativ (int a) {
         if (a>=0) {
            System.out.println("Передано положительно число");
         } else {
            System.out.println("Передано отрицательно число");
         }
        }

        /*
        4. Написать метод, которому в качестве параметра передается целое число.
        Метод должен вернуть true, если число отрицательное,
        и вернуть false если положительное.
         */
        public boolean moreOrLessThenZero (int a) {
        return (a<0);
        }

        /*
        5. Написать метод, который определяет, является ли год високосным,
        и возвращает boolean (високосный - true, не
високосный - false).
Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
         */
    public boolean leapYear (int year) {
        if (year%400 == 0) {
            return true;
        } else if (year%100 == 0) {
            return false;
        } else if (year%4 == 0) {
            return true;
        } else  return  false;
    }

    /*
    6. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и
условия заменить 0 на 1, 1 на 0;
     */
     public int[] reverseZeroAndOne(int[] array) {
         for (int i = 0; i < array.length; i++) {
             if(array[i] == 1) {
                 array[i] = 0;
             } else {
                 array[i] =1;
             }
         }
        return array;
     }

     /*
     7. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
      */
     public int[] fillTheArray(int[] array) {
        for (int i = 0;  i<array.length; i++) {
           array[i]= i+1;
        }
        return array;
     }

     /*
     8. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     9. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
      */
     public int[] multiArr(int[] array) {
        for (int i =0; i<array.length; i++) {
            if (array[i] < 6) {
                array[i]=array[i]*2;
            }
        }
        return array;
     }

     /*
     10. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью
цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то
есть [0][0], [1][1], [2][2], ..., [n][n];
      */
    public int[][] arrDouble (int[][] array) {
        for (int i = 0; i<array.length;i++) {
            for (int j = 0; j<array[i].length;j++) {
                if ((i == j) || (j==array[i].length-i-1)) {
                    array[i][j] = 1;
                }
            }
        }
        return array;
    }

    /*
    11.Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int
длиной len, каждая ячейка которого равна initialValue.
     */
    public int[] returnArr (int len, int initialValue) {
        int[] arr = new int[len];
        for (int i=0; i<arr.length;i++) {
            arr[i] = initialValue;
        }
        return arr;
    }


}