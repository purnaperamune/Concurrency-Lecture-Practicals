public class BankAccount {
    private long accountNumber;
    private double accountBalance;

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

    public synchronized double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public synchronized void withdraw(double amount){
        if(amount>accountBalance){
            throw new IllegalArgumentException("Insufficient balance in the account");
        }
        accountBalance -= amount;
        System.out.println(Thread.currentThread().getName()
                    + ", Account Balance: " + accountBalance);
    }

    public synchronized void deposit(double amount){
        accountBalance += amount;
        System.out.println(Thread.currentThread().getName()
                + ", Account Balance: " + accountBalance);
    }
}

