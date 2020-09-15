package Model;

public class Account {
    static int id = 1000;
    int accountId;
    float balance;
    User user;
    Bank bank;

    public Account(User user,int balance){
        this.accountId = id++;
        this.user = user;
        this.balance = balance;
    }



    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }


}
