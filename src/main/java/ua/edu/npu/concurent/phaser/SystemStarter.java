package ua.edu.npu.concurent.phaser;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

public class SystemStarter {
    private static final Phaser PHASER = new Phaser(1);;

    private static String OPEN  = "     door opening ";
    private static String CLOSE = "     door closing ";

    public static void main(String[] args)
            throws InterruptedException {
        ArrayList<Passenger> passengers;
        passengers = new ArrayList<>();
        // Формирование массива пассажиров
        for (int i = 1; i < 5; i++) {
            if ((int) (Math.random() * 2) > 0)
                // Этот пассажир проезжает одну станцию
                passengers.add(new Passenger(10 + i, i,
                        i + 1, PHASER));
            if ((int) (Math.random() * 2) > 0) {
                // Этот пассажир едет до конечной
                Passenger p = new Passenger(20 + i, i, 5, PHASER);
                passengers.add(p);
            }
        }

        for (int i = 0; i < 7; i++) {
            switch (i) {
                case 0:
                    System.out.println(
                            "Train started ");
                    PHASER.arrive();
                    break;
                case 6:
                    System.out.println(
                            "Train out");
                    PHASER.arriveAndDeregister();
                    break;
                default:
                    int currentStation = PHASER.getPhase();
                    System.out.println(
                            "Station " + currentStation);
                    for (Passenger pass : passengers)
                        if (pass.departure == currentStation) {
                            PHASER.register();
                            new Thread(pass).start();
                        }
                    System.out.println(OPEN);

                    PHASER.arriveAndAwaitAdvance();

                    System.out.println(CLOSE);
            }
        }
    }
}
