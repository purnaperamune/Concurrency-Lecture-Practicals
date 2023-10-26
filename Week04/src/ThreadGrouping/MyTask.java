package ThreadGrouping;

class MyTask implements Runnable {
    private static int sharedCounter = 0;

    @Override
    public void run() {
        ThreadGroup threadGroup02 = new ThreadGroup("ThreadGroup02");
        System.out.println("Thread Group Name2:: "+threadGroup02.getName());
        System.out.println("Thread Group Parent Name:: "+threadGroup02.getParent().getName()+"\n");

//        for (int i= 0; i < 100; i++) {
//            synchronized (MyTask.class) {
//                sharedCounter++;
//                System.out.println(Thread.currentThread().getName() + " - Counter: " + sharedCounter);
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}