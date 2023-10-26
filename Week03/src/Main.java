public class Main {
    public static void main(String[] args) {
        Meal meal = new Meal("Noodles");

        // Creating threads:: Threads are in the NEW state
        Thread threadChef = new Thread(new Chef(meal), "Thread Chef");
        Thread threadWaiter = new Thread(new Waiter(meal), "Thread Waiter");
        Thread threadCustomer = new Thread(new Customer(meal), "Thread Customer");


        System.out.println("Starting threads...");

        // Starting threads:: Threads are in the RUNNABLE state
        threadChef.start();
        threadWaiter.start();
        threadCustomer.start();


        System.out.println("Threads terminated!");
    }
}
