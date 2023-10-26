package Assignment;

public class ThreadManagementAssignment {
    public static void main(String[] args) {
        ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup");

        Thread thread1 = new Thread(myThreadGroup, new MyTask(), "Thread1");
        Thread thread2 = new Thread(myThreadGroup, new MyTask(), "Thread2");
        Thread thread3 = new Thread(myThreadGroup, new MyTask(), "Thread3");
        Thread thread4 = new Thread(myThreadGroup, new MyTask(), "Thread4");
        Thread thread5 = new Thread(myThreadGroup, new MyTask(), "Thread5");

        thread1.setPriority(10);
        thread2.setPriority(8);
        thread3.setPriority(6);
        thread4.setPriority(4);
        thread5.setPriority(2);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
