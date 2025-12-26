package thread.method;

public class Sleep {
    public static void main(String[] args)  {

        Thread th1 = new Thread(() -> {
            for(int i=0; i<300; i++){
                System.out.println("thread1");
            }
            System.out.println("thread1 종료");
        });

        Thread th2 = new Thread(() ->{
            for(int i=0; i<300; i++){
                System.out.println("thread2");
            }
            System.out.println("thread2 종료");
        });

        th1.start();
        th2.start();

        try {
            th1.sleep(300); // sleep 메서드는 해당 쓰레드를 실행하고 있는 쓰레드에 걸리기 때문에, thread
        }catch (InterruptedException e) {
        }

        System.out.println("메인 메서드 종료");

    }
}
