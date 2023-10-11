import com.sun.source.tree.WhileLoopTree;

public class BankAccount {
    private long accountNumber;
    private double accountBalance;
    public static final double DAILY_ALLOWANCE = 500;

    public BankAccount(long accountNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public synchronized void depositMoney(double depositAmount){
        if(depositAmount<0){
            throw new IllegalArgumentException("Deposit amount cannot be negative!");
        }

        while (this.accountBalance >= DAILY_ALLOWANCE){
            try {
                System.out.println("depositMoney:: Wife is waiting until the balance to be decreased!");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        accountBalance += depositAmount;
        System.out.println("Account balance after depositing: "+ accountBalance);
        notifyAll();
    }

    public synchronized void withdrawMoney(double withdrawalAmount){
        while (accountBalance<withdrawalAmount){
            try {
                System.out.println("withdrawMoney:: Waiting until the account balance to be increased!");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if(accountBalance<withdrawalAmount){
            System.out.println("Husband tried to withdraw, but not enough account balance.");
            throw new IllegalArgumentException("Insufficient balance in the account");
        }
        accountBalance -= withdrawalAmount;
        System.out.println("Account balance after withdrawing: "+accountBalance);
    }
}
