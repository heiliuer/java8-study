package study._010threads_runnables;

import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by hao.wang on 2017/2/17.
 */
public class _02TestExecutors {
    public static void main(String[] args) {

        ExecutorService executorService = executor_runnable();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                shutdown_executor(executorService);
            }
        }, 1000);


        try {
            executor_callable();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            executor_invokeall();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            executor_invokeany();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void executor_invokeall() throws InterruptedException {

        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        executor.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                        return future.get();
                    } catch (Exception e) {
                        throw new IllegalStateException(e);
                    }
                }).forEach(System.out::println);

    }

    private static void executor_invokeany() throws Exception {

        ExecutorService executor = Executors.newWorkStealingPool();

        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );

        // We use this method to create a bunch of callables with different durations from one to three seconds.
        // Submitting those callables to an executor via invokeAny() returns the string result of the fastest callable - in that case task2:
        String s = executor.invokeAny(callables);

        System.out.println(s);

    }

    public static ExecutorService executor_runnable() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();


        executorService.submit(() ->
                System.out.println("1." + Thread.currentThread().getName())
        );

        executorService.submit(() ->
                System.out.println("2." + Thread.currentThread().getName())
        );
        return executorService;
    }

    public static void shutdown_executor(ExecutorService executor) {
        System.out.println("attempt to shutdown executor..");
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutown failed");
        }
    }

    public static void executor_callable() throws ExecutionException, InterruptedException {

        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(task);

        System.out.println("future done?" + future.isDone());

        Integer result = future.get();
//        Any call to future.get() will block and wait until the underlying callable has been terminated

//        future.get(1, TimeUnit.SECONDS);
//        You can simply counteract those scenarios by passing a timeout:

        System.out.println("future done?" + future.isDone());

        System.out.println("result:" + result);

    }


}
