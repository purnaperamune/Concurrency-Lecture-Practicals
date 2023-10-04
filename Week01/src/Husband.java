public class Husband implements Runnable{
    private BankAccount bankAccount;

    public Husband(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("Thread husband started running!");
        for(int x=0;x<5;x++){
            bankAccount.withdraw(100);
        }

        System.out.println("Thread husband terminated!");
    }
}
