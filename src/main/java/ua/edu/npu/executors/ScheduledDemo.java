package ua.edu.npu.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
        ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
//        ScheduledFuture<?> future1 = executor.scheduleAtFixedRate(task, 3, 2, TimeUnit.SECONDS);
//        ScheduledFuture<?> future2 = executor.scheduleWithFixedDelay(task, 3, 2, TimeUnit.SECONDS);

        try {
            TimeUnit.MILLISECONDS.sleep(1702);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
        System.out.printf("Remaining Delay: %sms\n", remainingDelay);

        executor.shutdown();
    }
}
