package ua.edu.npu.simple.priority;

public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    public void run() {
        for (int i = 0; i < 71; i++) {
            System.out.println(getName() + " " + i);
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                System.err.print(e);
//            }
        }
    }

}
