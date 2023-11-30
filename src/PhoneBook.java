import java.util.*;

public class PhoneBook {

    Map<String, String> phoneBook = new HashMap<>();

    public void get(String name) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (Objects.equals(entry.getValue(), name)) {
                System.out.println(("Номер телефона человека с фамилией " + entry.getValue() + " : " + entry.getKey() + " "));
            }
        }
    }

    public void add(String name, String number) {
        phoneBook.put(number, name);
    }

    public void getAll() {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getValue() + ": " + entry.getKey());
        }
    }
}
