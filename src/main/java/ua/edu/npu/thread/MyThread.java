package ua.edu.npu.thread;


public class MyThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("I am demon " + this.isDaemon());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " running myThread");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " I am interrupted! ******");
        }
        //System.out.println(Thread.currentThread().getName() + " running myThread");
    }
}
