package pers.xf.learn.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        // Create a prototype.
        Concrete person = new Concrete();
        person.setAge(18);
        person.setName("Tom");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Hiking");
        hobbies.add("Swimming");
        person.setHobbies(hobbies);

        System.out.println("real person:\n\t" + person);

        // Shallow copy of a concrete prototype.
        Concrete clone = person.clone();
        System.out.println("shallow clone person:\n\t" + clone);

        // Deep copy of a concrete prototype.
        Concrete deepClone = person.deepClone();
        System.out.println("DEEP clone person:\n\t" + deepClone);

        // ---
        System.out.println("---");
        System.out.println("some change happens to real person");
        System.out.println("---");

        person.setAge(22);
        hobbies.add("Badminton");
        person.setHobbies(hobbies);
        System.out.println("real person:\n\t" + person);
        System.out.println("shallow clone person will follow real person:\n\t" + clone );
        System.out.println("Deep clone person won't follow real person:\n\t" + deepClone);

    }
}
