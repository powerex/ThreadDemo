package ua.edu.npu.executors;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    private static final int COUNT_CONTROL_PLACES = 5;
    private static final int COUNT_RIDERS         = 7;
    private static boolean[] CONTROL_PLACES = null;

    private static Semaphore SEMAPHORE = null;

    public static class Passenger implements Runnable
    {
        private int id;

        public Passenger(int id)  {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.printf(
                    "Passenger %d has come to passport control\n", id);
            try {
                SEMAPHORE.acquire();
                System.out.printf(
                        "\tPassenger %d checks any free clerk\n", id);
                int controlNum = -1;
                synchronized (CONTROL_PLACES){
                    for (int i = 0;
                         i < COUNT_CONTROL_PLACES; i++)
                        if (CONTROL_PLACES[i]) {
                            CONTROL_PLACES[i] = false;
                            controlNum = i;
                            System.out.printf(
                                    "\t\tPassenger %d has come to clerk %d.\n",
                                            id, i+1);
                            break;
                        }
                }

                Thread.sleep((int)
                        (Math.random() * 10+1)*1000);

                synchronized (CONTROL_PLACES) {
                    CONTROL_PLACES[controlNum] = true;
                }

                SEMAPHORE.release();
                System.out.printf(
                        "Passenger %d ends checking\n",
                        id);
            } catch (InterruptedException e) {}
        }
    }
    public static void main(String[] args)
            throws InterruptedException
    {
        CONTROL_PLACES = new boolean[COUNT_CONTROL_PLACES];
        for (int i = 0; i < COUNT_CONTROL_PLACES; i++)
            CONTROL_PLACES[i] = true;
        SEMAPHORE = new Semaphore(CONTROL_PLACES.length,
                true);

        for (int i = 1; i <= COUNT_RIDERS; i++) {
            new Thread(new Passenger(i)).start();
            Thread.sleep(400);
        }
    }
}
