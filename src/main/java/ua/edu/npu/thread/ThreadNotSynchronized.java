package ua.edu.npu.thread;

public class ThreadNotSynchronized {
    public static void main(String[] args) throws InterruptedException {
        Message3 message = new Message3();
        Message3 message2 = new Message3();
        message.setMsg("I am cool msg");
        message2.setMsg("I am cool msg");

        Runnable task = () -> {
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.printf("I am task %s. Message is %s\n",
                        Thread.currentThread().getName(), message.getMsg());
                message.setMsg("Not so cool now?");
            }
        };

        Thread thread = new Thread(task);
        thread.start();

        {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(" " + i);
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

class Message3 {
    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }



}
