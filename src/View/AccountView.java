package View;

import Controller.MessageController;
import Model.Account;
import Model.Bank;
import Model.User;


public class AccountView {

    Main view;
    MessageController message = new MessageController();

    public AccountView(Main view){
        this.view = view;
    }

    public void showAccountDetails(Account a){
        message.printInt("Kontonummer: ",a.getAccountId());
        message.printFloat("Saldo",a.getBalance());
    }


}
