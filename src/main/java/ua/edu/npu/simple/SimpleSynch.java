package ua.edu.npu.simple;

public class SimpleSynch {

    public static void main(String[] args) {

        Messanger m = new Messanger("Today", "Monday");

        Painter m1 = new Painter(m);
        Painter m2 = new Painter(m);
        Painter m3 = new Painter(m);


        m1.start();
        m2.start();
        m3.start();
    }

}

class Painter extends Thread {
    Messanger m;

    public Painter(Messanger m) {
        this.m = m;
    }

    public void run() {
        m.render();
    }
}

class Messanger {
    private String firstMsg;
    private String secondMsg;

    public Messanger(String firstMsg, String secondMsg) {
        this.firstMsg = firstMsg;
        this.secondMsg = secondMsg;
    }

    synchronized public void render() {
        System.out.print(firstMsg + " ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(secondMsg);
    }
}