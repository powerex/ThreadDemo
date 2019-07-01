package ua.edu.npu.simple.synch;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    private FileWriter fileWriter;
    public FileGenerator (String file) throws IOException {
        // file existing checking
        fileWriter = new  FileWriter(file, true);
    }
    public synchronized void writing(String str, int i) {
        try {
            fileWriter.append(str + i);
            System.out.print(str + i);
            Thread.sleep((long)(Math.random() * 50));
            fileWriter.append("->" + i + " ");
            System.out.print("->" + i + " ");
        } catch (IOException e) {
            System.err.print("file error: " + e);
        } catch (InterruptedException e) {
            System.err.print("threwad error: " + e);
        }
    }
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.err.print("closing file error: " + e);
        }
    }
}
