package View;



import java.util.*;

import Controller.*;
import Model.Account;
import Model.Bank;
import Model.User;
import Model.Person;


public class Main {

    public static void main(String[] args) {
	// write your code here
        MessageController mc = new MessageController();
        Main view = new Main();
        PersonView personView = new PersonView(view);
        Person model = new Person();
        RegisterUserView registerUserView = new RegisterUserView(view);
        User user = new User("","");
        PersonController pc = new PersonController(personView,model);

        LoginView loginView = new LoginView(view);
        LoginController lc = new LoginController(loginView,user,registerUserView);
        RegisterUserController registerUserController = new RegisterUserController(view,lc,registerUserView);





        boolean running = true;
        Scanner input = new Scanner(System.in);
        //AccountController ac = new AccountController(p,b);

        while(running){
            mc.print("-----Meny-----");
            mc.print("1.Logga in");
            mc.print("2. Skapa person");
            mc.print("3. Test");
            mc.print("");
            mc.print("Välj ett alternativ 1-3");
            int choice = input.nextInt();
            switch(choice){
                case 1:
                    loginView = new LoginView(view);
                    user = loginView.LoginInformation();
                    lc.validateLoginCredentials(user);
                    break;
                case 2:
                    model = pc.createNewPersonObject();
                    pc.addPersonToList(model);
                    //pc.printPersons();
                    user = registerUserController.createUserObject(model);
                    registerUserController.createNewUser(user.getUsername());
                    break;
                case 3:

                    break;
            }
        }

    }



}
