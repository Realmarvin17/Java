import java.util.HashSet;
import java.util.Set;

public class Homework6 {
    public static void main(String[] args) {
        Person person1 = new Person("Ivan", "Ivanov", 35, "male", "divorced",
                "Russia");
        Person person2 = new Person("John", "Doe", 44, "male", "divorced",
                "USA");
        Person person3 = new Person("Olga", "Petrova", 25, "female");
        Person person4 = new Person("Tom", "Hanks", 66, "male", "married",
                "USA");
        Person person5 = new Person("Maria", "Sharapova", 35, "female", "married",
                "Russia");
        Person person6 = new Person("Asher", "Angel", 17, "male", "single",
                "USA");

        Set<Person> persons = new HashSet<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        System.out.println(persons);
        System.out.println();
        for (Person p : persons
        ) {
            p.personIsMore20();
        }
        System.out.println();
        for (Person p : persons
        ) {
            if (p.getAge() > 20) {
                System.out.println(p);
            }
        }
        System.out.println();
        person5.changeStatus();
        System.out.println(person5);
        System.out.println();

        System.out.println(person1.canBeMarried(person3));
        System.out.println(person1.canBeMarried(person4));
        System.out.println(person6.canBeMarried(person2));
        System.out.println(person4.canBeMarried(person5));
    }
}