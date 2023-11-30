import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] arr = new String[]{
                "Один",
                "Два",
                "Три",
                "Четыре",
                "Пять",
                "Пять",
                "Один",
                "Шесть",
                "Семь",
                "Восемь",
                "Два",
                "Один",
                "Девять",
                "Десять"};

        Set<String> stringSet = new HashSet<>(Arrays.asList(arr));
        System.out.println("\nСписок уникальных слов массива arr: " + stringSet + "\n");

        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Слово " + "\"" + entry.getKey() + "\"" + " встречается " + entry.getValue() + " раз");
        }
        System.out.println("\n");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "8(111)111-11-11");
        phoneBook.add("Petrov", "8(222)222-22-22");
        phoneBook.add("Ivanov", "8(333)333-33-33");
        phoneBook.add("Sidorov", "8(444)444-44-44");
        phoneBook.add("Ivanov", "8(555)555-55-55");
        phoneBook.add("Kuznetsov", "8(666)666-66-66");
        phoneBook.add("Smirnov", "8(777)777-77-77");
        phoneBook.add("Smirnov", "8(888)888-88-88");

        phoneBook.get("Ivanov");


    }
}