public class Wife implements Runnable{
    private BankAccount bankAccount;

    public Wife(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        for(int x=0;x<10;x++){
        bankAccount.depositMoney(bankAccount.DAILY_ALLOWANCE);
        }
    }
}
