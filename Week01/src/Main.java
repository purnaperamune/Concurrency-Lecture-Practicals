public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(20200548, 10000);

        Thread threadHusband = new Thread(new Husband(account), "thread_Husband");
        Thread threadWife = new Thread(new Wife(account), "thread_Wife");

        threadHusband.start();
        threadWife.start();

    }
}
