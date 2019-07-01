package ua.edu.npu.simple.priority;

public class ThreadStarter {
    public static void main(String[] args) {
        MyThread min = new MyThread("Min");
        MyThread max = new MyThread("Max");
        MyThread norm = new MyThread("Norm");
        min.setPriority(Thread.MIN_PRIORITY); // 1
        max.setPriority(Thread.MAX_PRIORITY); // 10
        norm.setPriority(Thread.NORM_PRIORITY); // 5
        min.start();
        norm.start();
        max.start();

    }
}
