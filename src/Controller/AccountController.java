package Controller;

import Model.Account;
import Model.Bank;
import Model.User;
import View.AccountView;

import java.util.ArrayList;
import java.util.List;

public class AccountController {
    MessageController mc = new MessageController();
    boolean running = true;
    Account account;
    AccountView accountView;
    List<Account> bankAccounts = new ArrayList<>();
    LoginController loginController;

    public AccountController(AccountView accountView, Account account){
        this.account = account;
        this.accountView = accountView;

    }

    public List<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void createBankAccount(User user) {
        while (running) {
            System.out.println("Skapa ett nytt konto? [J/N] - 0 för att gå bakåt");
            String answer = mc.answer();
            switch(answer){
                case "j":
                    mc.print("Hur mycket vill du sätta in?");
                    int balance = Integer.parseInt(mc.answer());
                    mc.print("Ett nytt konto har skapats!");
                    mc.print("Du satte in "+balance+ "på ditt konto");
                    Account newAccount = new Account(user,balance);
                    addBankAccount(newAccount);
                   break;
                case "n":
                    running = false;
                    break;

                case "0":
                    running = false;
                    break;

            }

        }
    }

    public void addBankAccount(Account a){
        getBankAccounts().add(a);
    }

    public Account getAccountByUsername(User user){
        for (Account account:  getBankAccounts()) {
            if(account.getUser().equals(user)){
               return account;
            }
        }
        return null;

    }


    public void getAccountDetailsFromUsername(User user){
        for(Account a: getBankAccounts()){
            if(a.getUser().equals(user)){
                accountView.showAccountDetails(a);
                return;
            }

        }
        System.out.println("Finns inget Konto!");
    }









}
