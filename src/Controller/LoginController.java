package Controller;

import Model.Account;
import Model.Bank;
import Model.User;
import Model.Person;
import View.AccountView;
import View.LoginView;
import View.Main;
import View.RegisterUserView;


import java.util.ArrayList;
import java.util.List;


public class LoginController {



    List<User> userList = new ArrayList<>();
    MessageController message = new MessageController();
    boolean loggedIn = true;
    User user;
    Main view;
    LoginView loginView;
    RegisterUserView registerUserView;
    AccountView accountView = new AccountView(view);
    Account account = new Account(getUser(),0);
    AccountController accountController = new AccountController(accountView,account);





    public LoginController(LoginView view, User user, RegisterUserView registerUserView){
       this.user = user;
       this.loginView = view;
       this.registerUserView = registerUserView;
    }



    public void runLoggedInMenu(User user){
        startSession(user);
        System.out.println("SESSION STATUS:" +sessionStatus(user));
        while(sessionStatus(user) == true){
        loginView.welcomeMessage(user.getUsername());
        loginView.displayUserAlternatives();

            int choice = message.choice();
            performLoggedInUserChoice(choice,user);
        }
    }


    public void performLoggedInUserChoice(int choice,User user){


        switch (choice){
            case 1:
                //get AccountDetails
                accountController.getAccountDetailsFromUsername(user);
                    break;

            case 2:
                accountController.account = new Account(user,0);
                accountController.createBankAccount(user);

                break;
            case 3:
                System.out.println("logga ut");
                removeSession(user);
                break;
            default:
                System.out.println("Invalid choice");
        }

    }



    public void startSession(User user){
        user.setLoggedIn(true);
    }

    public void removeSession(User user){
        user.setLoggedIn(false);
    }

    public boolean sessionStatus(User user){
        return user.isLoggedIn();
    }

    public void printUsers(){
        message.print("---Användare---");
        userList.stream()
                .forEach(user -> message.print(user.getUsername()));
    }

    public void validateLoginCredentials(User user){
        if(isValidLogin(user) == false){
            message.print("Fel användarnamn eller lösenord..");
        }else{
            runLoggedInMenu(user);

        }
    }



    public User getUser(){
        return this.user;
    }

    public void addUserToUserList(User user){
        userList.add(user);
    }

    public void logOutUser(){
        updateLoginStatusByUsername(user);
    }

    public void updateLoginStatusByUsername(User user){
        userList.stream()
                .filter(searchedUser -> searchedUser.getUsername().equals(user.getUsername()));
                user.setLoggedIn(false);
    }

    public boolean isValidLogin(User user){
        boolean usernameAndPasswordMatching = userList.stream()
                .anyMatch(login -> login.getUsername().equals(user.getUsername()) && login.getPassword().equals(user.getPassword()));
        return usernameAndPasswordMatching;
    }

    public boolean doesUserAlreadyExist(String username){
        boolean isExisting = userList.stream()
                .anyMatch(login -> login.getUsername().equals(username));
        return isExisting;
    }

    public List<User> getUserList() {
        return userList;
    }

}
