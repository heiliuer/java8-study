package study._006streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {


    public static void main(String[] args) {
        sorted();
        filter();
        map();
        match();
        count();
        reduce();
    }

    public static List<String> getStringCollection() {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        return stringCollection;
    }

    private static void filter() {
        getStringCollection().stream().filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
    }

    private static void sorted() {
        getStringCollection().stream().sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void map() {
        getStringCollection().stream().map(String::toUpperCase).sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void match() {
        boolean anyMatch = getStringCollection().stream().anyMatch(s -> s.startsWith("a"));
        boolean allMatch = getStringCollection().stream().allMatch(s -> s.startsWith("a"));
        boolean noneMatch = getStringCollection().stream().noneMatch(s -> s.startsWith("a"));
    }

    private static void count() {
        long count = getStringCollection().stream().sorted().count();
        System.out.println(count);
    }

    private static void reduce() {
        long count = getStringCollection().stream().sorted().count();
        System.out.println(count);
    }
}
