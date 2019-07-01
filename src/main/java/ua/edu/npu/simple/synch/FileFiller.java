package ua.edu.npu.simple.synch;

public class FileFiller extends Thread {

    private FileGenerator fg;
    public FileFiller(String name, FileGenerator fg) {
        super(name);
        this.fg = fg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            fg.writing(getName(), i);
        }
    }
}
