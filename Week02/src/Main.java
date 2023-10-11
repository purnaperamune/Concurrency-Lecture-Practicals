public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(20200548, 0);

        Thread threadHusband = new Thread(new Husband(bankAccount), "Thread Husband");
        Thread threadWife = new Thread(new Wife(bankAccount), "Thread Wife");

        threadHusband.start();
        threadWife.start();
    }
}
