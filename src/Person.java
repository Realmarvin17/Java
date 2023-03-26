import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    private final String name;
    private final String surname;
    private final int age;
    private final String sex;
    private String marriedStatus;
    private final String citizenShip;

    public Person(String name, String surname, int age, String sex, String marriedStatus, String citizenShip) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.marriedStatus = marriedStatus;
        this.citizenShip = citizenShip;
    }

    public Person(String name, String surname, int age, String sex) {
        this(name, surname, age, sex, "N/A", "N/A");
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("name - " + name + " || surname - " + surname + " || sex- " + sex + " || married status - "
                + marriedStatus + " || age - " + age + " || citizenShip - " + citizenShip + "\n");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person otherPerson)) {
            return false;
        }
        return name.equals(otherPerson.name) && surname.equals(otherPerson.surname) && age == otherPerson.age &&
                sex.equals(otherPerson.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, sex);
    }

    public void personIsMore20() {
        if (age >= 20) {
            System.out.println("name - " + name + " || surname - " + surname + " || age - " + age + " Is more than 20");
        }
    }

    public void changeStatus() {
        System.out.println("name - " + name + " || surname - " + surname + " || married status - " + marriedStatus);
        Map<Integer, String> marStatus = new HashMap<>();
        marStatus.put(1, "single");
        marStatus.put(2, "married");
        marStatus.put(3, "divorced");
        System.out.println("Type number  - " + marStatus);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        marriedStatus = marStatus.get(n);
    }

    public boolean canBeMarried(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Person otherPerson)) {
            System.out.println("Only persons can be married!");
            return false;
        }
        if (sex.equals(otherPerson.sex) && (!Objects.equals(citizenShip, "USA") ||
                !Objects.equals(otherPerson.citizenShip, "USA"))) {
            if(!Objects.equals(citizenShip, "USA")) System.out.println("No gay marriage in " + citizenShip);
            if(!Objects.equals(otherPerson.citizenShip, "USA"))
                System.out.println("No gay marriage in " + otherPerson.citizenShip);
            return false;
        } else if (Objects.equals(marriedStatus, "married") ||
                Objects.equals(otherPerson.marriedStatus, "married")) {
            if (Objects.equals(marriedStatus, "married")) {
                System.out.println("name - " + name + " || surname - " + surname + " already married!");
            }
            if (Objects.equals(otherPerson.marriedStatus, "married")) {
                System.out.println("name - " + otherPerson.name + " || surname - "
                        + otherPerson.surname + " already married!");
            }
            return false;
        } else if (age < 18 || otherPerson.age < 18) {
            if (age < 18) {
                System.out.println("name - " + name + " || surname - " + surname + " is to young!");
            }
            if (otherPerson.age < 18) {
                System.out.println("name - " + otherPerson.name +
                        " || surname - " + otherPerson.surname + " is to young!");
            }
            return false;
        }
        return true;
    }
}