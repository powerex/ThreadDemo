package ua.edu.npu.thread;

public class ThreadWaitNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Runnable task = () -> {
            synchronized (lock) {
                try {
                    System.out.println("I am in : " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("After wait" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("I am interrupted : " + Thread.currentThread().getName());
                }
            }
            System.out.println("After synchronized" + Thread.currentThread().getName());
        };

        Runnable task2 = () -> {
            synchronized (lock) {
                try {
                    System.out.println("I am in : " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("After wait" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("I am interrupted : " + Thread.currentThread().getName());
                }
            }
            System.out.println("After synchronized" + Thread.currentThread().getName());
        };

        Thread thread = new Thread(task);
        thread.start();

        Thread thread2 = new Thread(task2);
        thread2.start();

        Thread.sleep(3000);

        System.out.println("LockDemo");
        synchronized (lock){
            System.out.println("LockDemo before notify");
//            lock.notify();
            lock.notifyAll();
        }
    }
}