package ua.edu.npu.simple.synchro;

public class BufferThread {
    static int counter = 0;
    static StringBuffer s = new StringBuffer();
//    static StringBuilder s = new StringBuilder();
    public static void main(String args[ ]) throws InterruptedException {
        new Thread(() -> {
            synchronized (s) {
                while (BufferThread.counter++ < 3) {
                    s.append("A");
                    System.out.print("> " + counter + " ");
                    System.out.println(s);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } // end of synchronized-case
        }).start();
        Thread.sleep(100);
        while (BufferThread.counter++ < 6) {
            System.out.print("< " + counter + " ");
            // thread main will wait unlock of object s
            s.append("B");
            System.out.println(s);
        }
    }
}
