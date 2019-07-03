package ua.edu.npu.executors.simple;

import java.util.concurrent.Callable;

public class StringReverser implements Callable<String> {
    String str;

    StringReverser(String str)
    {
        this.str = str;
    }

    public String call() throws Exception
    {
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        return builder.toString();
    }
}
