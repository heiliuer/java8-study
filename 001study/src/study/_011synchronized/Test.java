package study._011synchronized;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by hao.wang on 2017/2/17.
 */
public class Test {


    int count = 0;

    void increment() {
        count = count + 1;
    }

    synchronized void incrementSync() {
        count = count + 1;
    }

    void incrementSync2() {
//        The synchronized keyword is also available as a block statement.
        synchronized (this) {
            count = count + 1;
        }
    }

    // Instead of seeing a constant result count of 10000 the actual result varies with every execution of the above code.
    // The reason is that we share a mutable variable upon different threads without synchronizing the access to this variable which results in a race condition.
    void testNoneSynchronized() {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000).forEach(
                i -> executor.submit(this::increment)
        );


        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);

        //9995
    }

    private void testSynchronized() {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000).forEach(
                i -> executor.submit(this::incrementSync)
        );


        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
        //10000

    }

    private void testSynchronized2() {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 10000).forEach(
                i -> executor.submit(this::incrementSync2)
        );


        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
        //10000

    }

    public static void main(String[] args) {
//        new Test().testNoneSynchronized();
//        new Test().testSynchronized();
        new Test().testSynchronized2();
    }


}
