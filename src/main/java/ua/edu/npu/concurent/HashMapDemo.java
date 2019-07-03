package ua.edu.npu.concurent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo {
    Map<String, String> map;

    public HashMapDemo()
    {
        System.out.println("ConcurrentHashMap");
        createMap(true);
        addValue();

        System.out.println("\n\nHashMap");
        createMap(false);
        addValue();
    }

    private void addValue()
    {
        System.out.println("  before iterator : " + map);
        Iterator<String> iterator = map.keySet().iterator();

        System.out.print("  cycle : ");
        while(iterator.hasNext()){
            String key = iterator.next();
            if (key.equals("2")) {
                map.put(key + "new", "222");
            } else
                System.out.print("  " + key + "="
                        + map.get(key));
        }
        System.out.println();
        System.out.println("  after iterator : " + map);
    }

    private void createMap(boolean concurrent)
    {
        if (concurrent)
            map = new ConcurrentHashMap<>();
        else
            map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
    }

    public static void main(String[] args)
    {
        new HashMapDemo();
        System.exit(0);
    }
}
