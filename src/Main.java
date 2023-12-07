import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {


        List<Integer> intList = new Random().
                ints(5, 1, 11).
                boxed().
                collect(Collectors.toList());
       long countOfEven =  intList.stream().filter(s->s%2==0).count();
        System.out.println("В наборе рандомных чисел: " + intList + " четные встречаются " + countOfEven + " раз\n");



        ArrayList<String> list = new ArrayList<>();
        list.add("Highload");
        list.add("High");
        list.add("Load");
        list.add("Highload");

        long count1 = list.stream().filter(str -> str.equals("High")).count();
        String first = list.stream().findFirst().orElse("0");
        String last = list.stream().reduce((a, b) -> b).orElse("null");
        long count2 = list.stream().filter(str->str.contains("High")).count();

        System.out.println("Слово High встречается " + count1 + " раз");
        System.out.println("High как часть слова встречается " + count2 + " раз");
        System.out.println("Первое слово " + first);
        System.out.println("Последнее слово " + last + "\n");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("f15");
        list2.add("f10");
        list2.add("f4");
        list2.add("f2");
        list2.add("f4");

        String[] arr = list2.stream().sorted().toArray(String[]::new);
        System.out.println(Arrays.toString(arr) + "\n");

        Collection<Student> students = Arrays.asList(
                new Student("Дмитрий",17, Gender.MAN),
                new Student("Максим",20, Gender.MAN),
                new Student("Екатерина",20, Gender.WOMAN),
                new Student("Михаил",28, Gender.MAN)
        );
        OptionalDouble averageAge = students.stream().filter(x->x.getGender().equals(Gender.MAN)).mapToDouble(Student::getAge).average();
        System.out.println("Средний возраст студентов мужского пола " + averageAge.getAsDouble()+ "\n");


        System.out.println("Повестку может получить студент " + students.stream().filter(x->x.getGender().equals(Gender.MAN)).filter(x->x.getAge()>=18 && x.getAge()<=27).collect(Collectors.toList()));

        List<String> concols;
        Scanner scanner = new Scanner(System.in);
        concols = Stream.generate(scanner::nextLine).takeWhile(str->!str.isEmpty()).filter(s->s.startsWith("f")).collect(Collectors.toList());
        System.out.println("Парооли на f: " + concols);



    }

}