package Controller;

import Model.Account;
import Model.Bank;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class BankController {
    List<Bank> bankList = new ArrayList<>();
    List<Account> bankAccounts = new ArrayList<>();
    MessageController mc = new MessageController();
    boolean running = true;
    Bank bank;
    LoginController loginController;


    public BankController() {
        bankList.add(new Bank("SEB"));
        bankList.add(new Bank("Nordea"));
        bankList.add(new Bank("SWEDBANK"));
        bankList.add(new Bank("DANSKEBANK"));
    }

    public BankController(Bank bank){
        this.bank = bank;
    }

    public BankController(LoginController lc){
        this.loginController = lc;
    }



    public void displayBanks(){
        bankList.stream()
                .forEach(Bank -> mc.print(Bank.getNameOfBank()));

    }

    public Bank chooseBank(){
        String selectedBank = "SEB";
        mc.print("Välj vilken bank du vill starta ett konto hos:");
        displayBanks();
        do{
            selectedBank = mc.answer();
        }while(selectedBank.length() == 0);
        Bank bank = new Bank(selectedBank);

        return bank;

    }

    public Account getBankAccountByUsername(User user){
        for (Account customer: bankAccounts) {
            if(customer.getUser().equals(user)){
                return customer;
            }
        }
        return null;
    }





}

