package LectureSlideExample_ThreadArray;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup[] threadGroup = new ThreadGroup[6];
        Thread[] threads = new Thread[7];
        threads[0] = Thread.currentThread();
        threadGroup[0] = threads[0].getThreadGroup();

        threadGroup[1] = new ThreadGroup("ThreadGroup A");
        threadGroup[2] = new ThreadGroup("ThreadGroup B");
        threadGroup[3] = new ThreadGroup("ThreadGroup C");

        threads[1] = new Thread(threadGroup[1], new MyTask(), "Thread 2");

        threads[2] = new Thread(threadGroup[1], new MyTask(), "Thread 3");

        threads[3] = new Thread(threadGroup[3], new MyTask(), "Thread 4");

        threadGroup[4] = new ThreadGroup(threadGroup[2], "ThreadGroup B1");
        threadGroup[5] = new ThreadGroup(threadGroup[2], "ThreadGroup B2");

        threads[4] = new Thread(threadGroup[4], new MyTask(), "Thread 5");

        threads[5] = new Thread(threadGroup[4], new MyTask(), "Thread 6");

        threads[6] = new Thread(threadGroup[5], new MyTask(), "Thread 7");

        System.out.println("Active count of the threads before start : " + Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active count the groups before start : " + Thread.currentThread().getThreadGroup().activeGroupCount());

        for (int i = 1; i < threads.length; i++) {
            if (i % 2 == 0)
                threads[i].setPriority(Thread.MAX_PRIORITY);
            threads[i].start();
            System.out.println(threads[i].getThreadGroup().getName() + ": " + threads[i].getName() + " : " + threads[i].getPriority());
        }

        threadGroup[2].setMaxPriority(Thread.NORM_PRIORITY); // this will not override the priority of the threads in the group set before

        // this will also not ovveride the priority of the threads in the group set before
        for (int i = 1; i < threads.length; i++) {
            threads[i].setPriority(Thread.MAX_PRIORITY);
            System.out.println(threads[i].getThreadGroup().getName() + ": " + threads[i].getName() + " : " + threads[i].getPriority());
        }

        for (int i = 1; i < threads.length; i++) {
            System.out.println(threads[i].getThreadGroup().getName() + ": " +threads[i].getName() + " " + threads[i].getPriority());
        }

        System.out.println("Active count of the threads after start : " + Thread.currentThread().getThreadGroup().activeCount());
        System.out.println("Active count the groups after start : " + Thread.currentThread().getThreadGroup().activeGroupCount());

        Thread[] threads1 = new Thread[Thread.currentThread().getThreadGroup().activeCount() * 2];
        Thread.currentThread().getThreadGroup().enumerate(threads1);

        ThreadGroup[] threadGroups1 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount() * 2];
        Thread.currentThread().getThreadGroup().enumerate(threadGroups1);

        for (Thread thread : threads1) {
            if (thread != null) {
                System.out.println("Enumrated threads: " + thread.getName());
            }
        }

        for (ThreadGroup threadGroup1 : threadGroups1) {
            if (threadGroup1 != null) {
                System.out.println( "Enumurated threads groups: " + threadGroup1.getName());
            }
        }

    }
}
