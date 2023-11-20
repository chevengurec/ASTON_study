import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        AppData appData = new AppData(new String[]{"Value 1", "Value 2", "Value 3"}, new int[][]{{100, 200, 300}, {1, 2, 3}, {45, 45, 12344}});
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < appData.getHeader().length; i++) {
            stringBuilder1.append(appData.getHeader()[i]).append(";");
        }
        stringBuilder1.append("\n");

        for (int i = 0; i < appData.getData().length; i++) {
            for (int j = 0; j < appData.getData()[i].length; j++) {
                stringBuilder1.append(appData.getData()[i][j]).append(";");
            }
            stringBuilder1.append("\n");

        }

        try (FileWriter writer = new FileWriter("C:/Users/evgen/OneDrive/Desktop/table.csv")) {
            writer.write(stringBuilder1.toString());
            System.out.println("CSV файл создан");
        } catch (Exception e) {
            System.out.println("Ошибка");
        }


    }
}