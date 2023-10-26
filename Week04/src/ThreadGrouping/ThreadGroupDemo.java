package ThreadGrouping;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        // Thread Group - MAIN
        System.out.println("Thread Name:: "+Thread.currentThread().getName());
        System.out.println("Thread Group:: "+Thread.currentThread().getThreadGroup().getName());
        System.out.println("Thread Group Parent Name:: "+Thread.currentThread().getThreadGroup().getParent().getName()+"\n");

        Thread t1 = new Thread(new MyTask(), "Thread01"); // To what ThreadGroup does this thread belong?
//        t1.start();

        System.out.println("Thread Name:: "+t1.getName());
        System.out.println("Thread Group:: "+t1.getThreadGroup().getName());
        System.out.println("Thread Group Parent Name:: "+t1.getThreadGroup().getParent().getName()+"\n");

        ThreadGroup threadGroup01 = new ThreadGroup("ThreadGroup01");
        System.out.println("Thread Group Name:: "+threadGroup01.getName());
        System.out.println("Thread Group Parent Name:: "+threadGroup01.getParent().getName()+"\n");

        Thread t2 = new Thread(threadGroup01, new MyTask(),"Thread02"); // To what ThreadGroup does this thread belong?
        t2.start();

        System.out.println("Thread Name:: "+t2.getName());
        System.out.println("Thread Group:: "+t2.getThreadGroup().getName()+"\n");

        // threadGroup03 belongs to threadGroup01
        ThreadGroup threadGroup03 = new ThreadGroup(threadGroup01,"ThreadGroup03");
        System.out.println("Thread Group Name:: "+threadGroup03.getName());
        System.out.println("Thread Group Parent Name:: "+threadGroup03.getParent().getName()+"\n");

        Thread t3 = new Thread(threadGroup03, new MyTask(),"Thread03");
        t3.start();
        System.out.println("Thread Name:: "+t3.getName());
        System.out.println("Thread Group:: "+t3.getThreadGroup().getName());
    }
}
