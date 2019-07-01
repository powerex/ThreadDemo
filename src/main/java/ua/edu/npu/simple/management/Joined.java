package ua.edu.npu.simple.management;

public class Joined extends Thread {
    public Joined (String name) {
        super(name);
    }
    public void run() {
        String nameT = getName();
        long timeout = 0;
        System.out.println("Start thread " + nameT);
        try {
            switch (nameT) {
                case "First":
                    timeout = 5000;
                    break;
                case  "Second":
                    timeout = 1000;
            }
            Thread.sleep(timeout);
            System.out.println("End thread " + nameT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
