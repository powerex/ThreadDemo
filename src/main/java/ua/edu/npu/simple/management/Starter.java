package ua.edu.npu.simple.management;

public class Starter {
    static {
        System.out.println("Старт потока main");
    }
    public static void main(String[ ] args) {
        Joined t1 = new Joined("First");
        Joined t2 = new Joined("Second");
        t1.start();
        t2.start();
        try {
            t1.join(); // thread main stopped while thread t1 not finished
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()); // name of current thread
    }
}
