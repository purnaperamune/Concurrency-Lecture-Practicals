public class Wife implements Runnable{
    private BankAccount bankAccount;

    public Wife(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        System.out.println("Thread wife is started running!");
        for(int x=0;x<5;x++){
            bankAccount.deposit(50);
        }

        System.out.println("Thread wife terminated!");
    }
}
