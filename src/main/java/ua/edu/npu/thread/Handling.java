package ua.edu.npu.thread;

public class Handling {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Error " + e.getMessage());
            }
        });
        System.out.println(2 / 0);
    }
}

