public class Main {

    public static void main(String[] args) {

        Employee[] emplArray = new Employee[5];
        emplArray[0] = new Employee("Ivanov Ivan", "Engineer",
                "ivivan", "892312312", 30000, 30);
        emplArray[1] = new Employee("Petrov Petr", "PR manager",
                "petroff", "8999000111222", 100000, 48);
        emplArray[2] = new Employee("Ivanova Elena", "HR",
                "ivelena", "81234567890", 70000, 23);
        emplArray[3] = new Employee("Romanov Roman", "Director",
                "director", "87777777777", 350000, 50);
        emplArray[4] = new Employee("Romanova Svetlana", "Deputy Director",
                "dd","89999999999", 287000, 45);

        for(Employee employee: emplArray) {
           if (employee.age>40) {
               System.out.println("\nФИО: " + employee.full_name + "\n" +
                       "Должность: " + employee.position + "\n" +
                       "Почта: " + employee.email+ "\n" +
                       "Номер телефона: " + employee.phone_number + "\n" +
                       "Зарплата: " + employee.salary + "\n" +
                       "Возраст: " + employee.age);
           }
        }

        Park.Information karusel = new Park("Карусель").new Information(
               "10.00-15.00", 350);
        Park.Information train = new Park("Поезд").new Information(
                "10.00-18.00", 500);
        Park.Information kacheli = new Park("Качели").new Information(
                "11.00-20.00", 100);

        System.out.println("\nВремя работы карусели: " + karusel.getTime());
        System.out.println("\nСтоимость качелей: " + kacheli.getPrice());
        System.out.println("\nВремя работы и стоимость поезда:\n"+
                "Время работы: " + train.getTime() + "\n"+
                "Стоимость: " + train.getPrice());

    }

}
