package ua.edu.npu.concurent.phaser;

import java.util.concurrent.Phaser;

public class Passenger implements Runnable {

    private static String WAIT  = " waiting at the station ";
    private static String ENTER = " entered in wagon"   ;
    private static String EXIT  = " out of wagon ";
    private static String SPACE = "    ";

    int id;
    int departure;
    int destination;
    Phaser PHASER;

    public Passenger(int id, int departure, int destination, Phaser phaser)
    {
        this.id          = id;
        this.departure   = departure;
        this.destination = destination;
        this.PHASER = phaser;
        System.out.println(this + WAIT + departure);
    }

    @Override
    public void run()  {
        try {
            System.out.println(SPACE + this + ENTER);

            while (PHASER.getPhase() < destination)
                PHASER.arriveAndAwaitAdvance();

            Thread.sleep(500);
            System.out.println(SPACE + this + EXIT);

            PHASER.arriveAndDeregister();
        } catch (InterruptedException e) {}
    }

    @Override
    public String toString()
    {
        return "Passenger " + id +
                " {" + departure + " -> " + destination + '}';
    }
}
