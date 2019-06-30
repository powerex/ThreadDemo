package ua.edu.npu.thread;

public class ThreadStateDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("LockDemo thread " + Thread.currentThread().getState());
        Thread thread = new MyThread();
        System.out.println("Thread thread " + thread.getState());
        thread.start();
        System.out.println("Thread thread " + thread.getState());

        System.out.println("LockDemo thread " + Thread.currentThread().getState());
        Thread.sleep(5000);
        System.out.println("Thread thread " + thread.getState());
    }
}
