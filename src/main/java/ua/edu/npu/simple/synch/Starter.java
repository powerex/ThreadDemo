package ua.edu.npu.simple.synch;

import java.io.IOException;

public class Starter {
    public static void main(String[ ] args)  {
        FileGenerator s = null;
        try {
            s = new  FileGenerator ("result.txt");
            FileFiller t1 = new FileFiller("First", s);
            FileFiller t2 = new FileFiller("Second", s);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (IOException e) {
            System.err.print("file error: " + e);
        } catch (InterruptedException e) {
            System.err.print("thread error: " + e);
        } finally {
            s.close();
        }
    }

}
