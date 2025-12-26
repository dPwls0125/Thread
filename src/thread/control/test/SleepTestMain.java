package thread.control.test;

public class SleepTestMain {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("실행 중 Thread" + Thread.currentThread().getName());
        });

        t.run();
        t.start();

    }
}
