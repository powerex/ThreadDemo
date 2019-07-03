package ua.edu.npu.executors.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Future<String> task = service.submit(new StringReverser("EPAM"));

        while (!task.isDone()) {
            Thread.sleep(100);
        }

        try {
            System.out.println("Reversed string : " + task.get());
        } catch (Exception ie) {
            ie.printStackTrace(System.err);
        }

        service.shutdown();
    }
}
