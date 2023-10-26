package LectureSlideExample_ThreadArray;
    class MyTask implements Runnable {

        private static int sharedCounter = 0;



        @Override

        public void run() {
            //Two ThreadGroups will be created. because t1.run and t3.run is same
//            ThreadGroup myThreadGroup = new ThreadGroup("MyThreadGroup2");
//            System.out.println("Thread Group Name: " + myThreadGroup.getName());
//            System.out.println("Thread Group Parent Name: " + myThreadGroup.getParent().getName());
            for (int i = 0; i < 5; i++) {

                synchronized (MyTask.class) {

                    sharedCounter++;

                    System.out.println(Thread.currentThread().getName() + " - Counter: " + sharedCounter);

                }

                try {

                    Thread.sleep(100);

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        }

    }

