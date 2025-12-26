package thread.control.test;

public class RaceConditionTest {

    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()-> {
            for(int i=0; i<1000; i++) count++;
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<1000; i++) count++;
        });

        t1.start();
        t2.start();

        t1.join(); // 메인 쓰레드가 T1의 작업이 끝날 때 까지 기다린다.
        t2.join(); // 메인 쓰레드가 T2의 작업이 끝날 때 까지 기다린다.

        System.out.println(count);
    }
}
