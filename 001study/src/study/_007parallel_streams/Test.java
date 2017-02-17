package study._007parallel_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/16 0016.
 */
public class Test {

//    As mentioned above streams can be either sequential or parallel.
// Operations on sequential streams are performed on a single thread while operations on parallel streams are performed concurrently on multiple threads.

    public static void main(String[] args) {
        sequential_sort();
        parallel_sort();
    }

    public static List<String> getStringCollection() {
        List<String> stringCollection = new ArrayList<>();
        Arrays.stream(new String[20000]).forEach((str) -> stringCollection.add(UUID.randomUUID().toString()));
        return stringCollection;
    }

    private static void sequential_sort() {
        long l = System.nanoTime();
        long count = getStringCollection().stream().sorted().count();
        System.out.println("count:" + count);
        long l1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(l1 - l);
        System.out.println("sequential_sort take time:" + millis + "ms");
        //423ms
    }

    private static void parallel_sort() {
        long l = System.nanoTime();
        long count = getStringCollection().parallelStream().sorted().count();
        System.out.println("count:" + count);
        long l1 = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(l1 - l);
        System.out.println("parallel_sort take time:" + millis + "ms");
        //50ms
    }

}
