package View;

import Controller.MessageController;
import Model.Account;
import Model.User;

public class LoginView {

    LoggedInUserView loggedinUserView;
    MessageController message = new MessageController();
    Main view;
    AccountView accountView;
    Account account;


    //constructor
    public LoginView(Main view) {
        this.view = view;

    }



    public User LoginInformation(){

        message.print("Användarnamn: ");
        String username = message.answer();
        message.print("Lösenord: ");
        String password = message.answer();
        User user = new User(username,password);
        return user;
    }

    public void displayUserAlternatives(){
        message.print("1.Mitt konto");
        message.print("2.Nytt konto");
        message.print("3.Logga ut");
    }

    public void welcomeMessage(String username){
        message.print("----Välkommen "+username+" ----");
    }



}
