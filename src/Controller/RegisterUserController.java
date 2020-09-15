package Controller;

import Model.Person;
import Model.User;
import View.Main;
import View.RegisterUserView;

public class RegisterUserController {
    Main view;
    LoginController lc;
    MessageController message = new MessageController();
    RegisterUserView registerUserView;
    public RegisterUserController(Main view, LoginController lc,RegisterUserView registerUserView){
        this.view = view;
        this.lc = lc;
        this.registerUserView = registerUserView;
    }

    public void createNewUser(String username){
        String temporaryUsername = username;
        if(lc.doesUserAlreadyExist(username) == true){
            message.print("En användare med det namnet finns redan..");
            message.print("Välj ett nytt användarnamn");
            temporaryUsername = message.answer();
        }
        message.print("Välj ett lösenord");
        String password = message.answer();
        System.out.println("passwordlength: "+password.length());
        if(isLengthOfPasswordValid(password) != true){
            do{
                message.print("Ditt lösenord får inte vara tomt");
                password = message.answer();
            }while(isLengthOfPasswordValid(password) == false);
        }
            User newUser = new User(temporaryUsername,password);
            newUser.setLoggedIn(true);
            lc.addUserToUserList(newUser);
            //printUsers();
            registerUserView.RegisterUserSuccessMessage();



    }

    public boolean isLengthOfPasswordValid(String password){
        if(password.length() > 0){
            return true;
        }else{
            return false;
        }
    }

    public User createUserObject(Person person){
        return new User(person.getName(),null);
    }
}
