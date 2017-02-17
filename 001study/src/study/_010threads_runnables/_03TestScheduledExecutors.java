package study._010threads_runnables;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by hao.wang on 2017/2/17.
 */
public class _03TestScheduledExecutors {
    public static void main(String[] args) throws InterruptedException {
        executor();
        executorFixed();
    }

    private static void executor() throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling:" + System.nanoTime());

        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainDelay = future.getDelay(TimeUnit.MICROSECONDS);
        System.out.printf("Remaining Delay:%sms\n", remainDelay);

    }

    private static void executorFixed() throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling:" + System.nanoTime());

        ScheduledFuture<?> future = executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);

        TimeUnit.MILLISECONDS.sleep(1337);

        long remainDelay = future.getDelay(TimeUnit.MICROSECONDS);
        System.out.printf("Remaining Delay:%sms\n", remainDelay);

    }

}
