public class Main {
    public static void main(String[] args) {
        System.out.println("Priority: "+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);

        System.out.println("Priority: "+Thread.currentThread().getPriority());
        Thread t1 = new Thread(new MyTask(), "Thread01");
        Thread t2 = new Thread(new MyTask(), "Thread02");

        System.out.println("t1:: Current State: "+ t1.getState());
        System.out.println("t2:: Current State: "+ t2.getState());
        System.out.println("Current thread: "+ Thread.currentThread().getState());

        t1.setPriority(Thread.MIN_PRIORITY);
        t1.setDaemon(true);
        t1.start();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        t2.setPriority(Thread.MAX_PRIORITY);
        t2.setDaemon(true);
        t2.start();
        System.out.println("t1:: Current State, after starting: "+ t1.getState());
        System.out.println("t2:: Current State, after starting: "+ t2.getState());

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("t1:: Current state, after sleep: "+ t1.getState());
        System.out.println("t2:: Current state, after sleep: "+ t2.getState());
    }
}
