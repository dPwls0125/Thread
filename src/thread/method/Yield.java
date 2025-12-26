package thread.method;

public class Yield {
    public static void main(String[] args) {
        ThreadEx2 th1 = new ThreadEx2("*");
        ThreadEx2 th2 = new ThreadEx2("*");
        ThreadEx2 th3 = new ThreadEx2("*");
        th1.start();
        th2.start();
        th3.start();

        try{
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        }catch(InterruptedException e){}
    }
}


class ThreadEx2 implements Runnable{
    boolean suspended = false;
    boolean stopped = false;
    Thread th;

    public ThreadEx2(String name){
        th = new Thread(this,name);
    }
    @Override
    public void run() {
        String name = th.getName();
        while(!stopped){
            if(!suspended){
                System.out.println(name);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println(name + " - interrupted");
                }
            }else{
                Thread.yield();
            }
        }
        System.out.println(name + " - stopped");
    }

    public void suspend(){
        suspended = true;
        th.interrupt();
        System.out.println(th.getName() + " - interrupted() by suspend()");
    }

    public void stop(){
        stopped = true;
        th.interrupt();
        System.out.println(th.getName() + " - interrupt() by stop()");
    }

    public void resume() {suspended = false;}
    public void start() {th.start();}
}
