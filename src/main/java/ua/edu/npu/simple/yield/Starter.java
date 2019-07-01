package ua.edu.npu.simple.yield;

public class Starter {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("Start thread 1");
            Thread.yield();
            System.out.println("End thread 1");
        }).start();
        new Thread(() -> {
            System.out.println("Start thread 2");
            System.out.println("End thread 2");
        }).start();
    }
}
