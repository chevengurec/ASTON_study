public class Main {

    public static void main(String[] args) {

        String[][] arr1 = new String[][]{
                {"5","6","7","8"},
                {"1","2","3","4"},
                {"5","6","7","8"}
        };

        String[][] arr2 = new String[][]{
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"5","6","7","8"}
        };

        String[][] arr3 = new String[][]{
                {"1","2","3","4"},
                {"5","6","7","8"},
                {"1","Ж","3","4"},
                {"5","6","7","8"}
        };


        try {
           int sum1 = sumOfStrings(arr1);
            System.out.println("Сумма чисел в первом примере: "+ sum1);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }


        try {
            int sum2 = sumOfStrings(arr2);
            System.out.println("Сумма чисел во втором примере " + sum2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
           e.printStackTrace();
        }

        try {
            int sum3 = sumOfStrings(arr3);
            System.out.println("Сумма чисел в третьем примере "+ sum3);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
           e.printStackTrace();
        }

    }

    public static int sumOfStrings (String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4)  {
            throw new MyArraySizeException("Число строк не равно 4");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length;j++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException("В одной из строк число элементов не равно 4");
                }
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке c координатами " + i + ", " + j);
                }
            }
        }
        return count;
    }
}
