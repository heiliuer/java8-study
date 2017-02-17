package study._010threads_runnables;

import java.util.concurrent.TimeUnit;

/**
 * Created by hao.wang on 2017/2/17.
 */
public class _01TestRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Foo " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Bar " + name);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

    }
}
