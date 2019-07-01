package ua.edu.npu.simple.independence;

public class Starter {
    public static void main(String[] args) {
        new SimpleThread().start();
        System.out.println("end of main with exception");
        throw new RuntimeException();

    }
}
