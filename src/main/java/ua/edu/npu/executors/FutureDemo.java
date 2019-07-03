package ua.edu.npu.executors;

import java.util.concurrent.*;

public class FutureDemo {

    static Callable task = () -> {
        try {
            TimeUnit.SECONDS.sleep(1);
            return 123;
        }
        catch (InterruptedException e) {
            throw new IllegalStateException("task interrupted", e);
        }
    };

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
//        executor.shutdown();
        System.out.println("future done? " + future.isDone());

        Integer result = null;
        try {
            result = future.get();
//            result = future.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("future done? " + future.isDone());
        System.out.print("result: " + result);

        executor.shutdown();
    }
}
