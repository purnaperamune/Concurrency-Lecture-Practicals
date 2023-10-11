public class Husband implements Runnable{
    private BankAccount bankAccount;

    public Husband(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for(int x=0;x<10;x++){
        bankAccount.withdrawMoney(bankAccount.DAILY_ALLOWANCE);
        }
    }
}
