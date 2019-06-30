package ua.edu.npu.thread;

public class ThreadCreationDemo {
    public static void main(String[] args) {
        System.out.println("LockDemo start");
        Thread myThread = new MyThread();
        myThread.start();


        System.out.println("LockDemo, myThread is interrupted? " + myThread.isInterrupted());
        myThread.interrupt();
        System.out.println("LockDemo, myThread is interrupted? " + myThread.isInterrupted());
        Runnable myRunnable = new MyRunnable();
//        myRunnable.run();
        Thread thread = new Thread(myRunnable);
        thread.setDaemon(true);
        thread.isDaemon();
        thread.start();
        System.out.println("End main");
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " running myRunnable");
    }
}

