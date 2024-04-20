package threads;

public class MultithreadingDemo2 implements Runnable {

    public static void main(String args[]) {
        MultithreadingDemo2 obj = new MultithreadingDemo2();
        Thread thread = new Thread(obj);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("My thread is in running state");
    }
}
