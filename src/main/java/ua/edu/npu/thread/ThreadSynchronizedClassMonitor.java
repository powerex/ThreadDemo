package ua.edu.npu.thread;

public class ThreadSynchronizedClassMonitor {

    public static void main(String[] args) throws InterruptedException {
        Message2 message = new Message2();
        Message2 message2 = new Message2();
        Message2 message3 = new Message2();
        Message2 message4 = new Message2();
        message.setMsg("I am cool msg");
        message2.setMsg("I am cool msg");
        message3.setMsg("I am cool msg");
        message4.setMsg("I am cool msg");

        Runnable task = () -> {
            synchronized (message){
                System.out.printf("I am task %s. Message is %s\n",
                        Thread.currentThread().getName(), message.getMsg());
                message.setMsg("Not so cool now?");
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        synchronized (Message2.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(" " + i);
                Thread.sleep(1000);
            }
            System.out.printf("I am main %s. Message is %s\n",
                    Thread.currentThread().getName(), message.getMsg());
            message2.setMsg("Still cool!");
        }

        Thread.sleep(6000);
        System.out.printf("I am main %s. Message is %s\n",
                Thread.currentThread().getName(), message.getMsg());

    }

}

class Message2 {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }



}
