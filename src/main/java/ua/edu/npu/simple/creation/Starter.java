package ua.edu.npu.simple.creation;

public class Starter {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        Thread sounder = new Thread(new Sounder());
        // start threads
        messenger.start();
        sounder.start();
//        Sounder sounder2 = new Sounder();

// only method execudet, but thread s are not created
//        messenger.run();
//        sounder.run();
    }
}
