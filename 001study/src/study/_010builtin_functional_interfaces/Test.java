package study._010builtin_functional_interfaces;

import java.util.Optional;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {

    //    The JDK 1.8 API contains many built-in functional interfaces.
// Some of them are well known from older versions of Java like Comparator or Runnable.
// Those existing interfaces are extended to enable Lambda support via the @FunctionalInterface annotation.
//
// But the Java 8 API is also full of new functional interfaces to make your life easier.
// Some of those new interfaces are well known from the Google Guava library.
// Even if you're familiar with this library you should keep a close eye on how those interfaces are extended by some useful method extensions.
    public static void main(String[] args) {
        optionals();
    }

    private static void optionals() {
        Optional<String> bam = Optional.of("bam");
        bam.isPresent();
        bam.get();
        bam.orElse("fallback");
        bam.ifPresent(System.out::println);
    }

}
