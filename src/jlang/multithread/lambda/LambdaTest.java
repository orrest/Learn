package jlang.multithread.lambda;

import javax.swing.Timer;
import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {


        var timer = new Timer(1000, System.out::println);

        LocalDate day = LocalDate.now();
        Objects.requireNonNullElseGet(day, () -> LocalDate.of(1970, 1, 1));

        ArrayList<Integer> arrayList = new ArrayList<>();;
        arrayList.add(5); arrayList.add(6); arrayList.add(7);
        Predicate<Integer> isNull = e -> e == null;
        arrayList.removeIf(isNull);

        BiFunction<String, String, Integer> comp_bi =
                (o1, o2) -> o1.length() - o2.length();

        Comparator<String> comp = (o1, o2) ->
                o1.length() - o2.length();

        String[] planets = new String[] {
                "Mercury", "Venus", "Earth", "Jupiter", "Saturn", "Uranus", "Neptune"
        };

        System.out.println("Sorted by length: ");
        Arrays.sort(planets, (o1, o2) -> o1.length()-o2.length());
        System.out.println(Arrays.toString(planets));

        Arrays.sort(planets, String::compareToIgnoreCase);
    }
}
