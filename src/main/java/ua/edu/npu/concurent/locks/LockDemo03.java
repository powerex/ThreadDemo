package ua.edu.npu.concurent.locks;

import ua.edu.npu.concurent.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDemo03 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Map<String, String> map = new HashMap<>();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        executor.submit(() -> {
            lock.writeLock().lock();
            try {
                Utils.sleep(1);
                map.put("java", "EPAM");
            } finally {
                lock.writeLock().unlock();
            }
        });

        Runnable readTask = () -> {
            lock.readLock().lock();
            try {
                System.out.println(map.get("java"));
                Utils.sleep(1);
            } finally {
                lock.readLock().unlock();
            }
        };
        executor.submit(readTask);
        executor.submit(readTask);

        Utils.stop(executor);
    }
}
