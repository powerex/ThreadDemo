package ua.edu.npu.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();
        Producer producer = new Producer(warehouse);
        Consumer consumer = new Consumer(warehouse);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Warehouse {
    private int product;
    ReentrantLock locker;
    Condition condition;

    public Warehouse() {
        this.locker = new ReentrantLock();
        this.condition = locker.newCondition();
    }

    public void getProduct() {

        locker.lock();
        try {

            while (product < 1)
                condition.await();

            product--;
            System.out.println("Customer bought 1 product");
            System.out.println("Products at Warehouse: " + product);


            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }

    public void addProduct() {

        locker.lock();
        try {

            while (product >= 3)
                condition.await();

            product++;
            System.out.println("Supplier add 1 product");
            System.out.println("Products at Warehouse: " + product);

            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}

class Producer implements Runnable {

    Warehouse warehouse;

    Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            warehouse.addProduct();
        }
    }
}

class Consumer implements Runnable {

    Warehouse warehouse;

    Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void run() {
        for (int i = 1; i < 6; i++) {
            warehouse.getProduct();
        }
    }
}
