package ua.edu.npu.thread;

public class ThreadMonitorDemo {
    public static void main(String[] args) throws InterruptedException {
        Message message = new Message();
        message.setMsg("I am cool msg");

        Runnable task = () -> {
            synchronized (message){
                System.out.printf("I am task %s. Message is %s\n",
                        Thread.currentThread().getName(), message.getMsg());
                message.setMsg("Not so cool now?");
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        synchronized (message){
            for(int i=0; i<5; i++){
                Thread.sleep(1000);
                System.out.println(" " + i);
            }
            System.out.printf("I am main %s. Message is %s\n",
                    Thread.currentThread().getName(), message.getMsg());
            message.setMsg("Still cool!");
        }

        Thread.sleep(6000);
        System.out.printf("I am main %s. Message is %s\n",
                Thread.currentThread().getName(), message.getMsg());

    }
}

class Message {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }


}
