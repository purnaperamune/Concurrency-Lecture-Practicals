package Example02;

public class Runner {
    public static void main(String[] args) {
        Plate plate = new Plate("Rice");

        Thread producer = new Thread(new Mom(), "Thread_Mom:: Producer");
        Thread consumer = new Thread(new Mom(), "Thread_Son:: Consumer");

        producer.start();
        consumer.start();
    }
}
