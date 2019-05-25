import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    private Lock lock = new ReentrantLock(false);

    private int value;

    private int getNext() {
        lock.lock();

        int newValue = value++;

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();
        return newValue;
    }

    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "---" + threadTest.getNext());

                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + "---" + threadTest.getNext());

                }

            }
        }).start();
    }
}
