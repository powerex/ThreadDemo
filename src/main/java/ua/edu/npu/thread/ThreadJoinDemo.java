package ua.edu.npu.thread;

public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        thread.setName("Thread0");
        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(5);
        thread2.setPriority(Thread.MIN_PRIORITY);

        System.out.println("LockDemo");
        thread.start();
        thread1.start();
        thread2.start();

        thread.join(2000);
        System.out.println("LockDemo end");
    }
}
