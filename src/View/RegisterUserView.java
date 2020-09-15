package View;

import Controller.MessageController;

public class RegisterUserView {

    Main view;
    MessageController message = new MessageController();
    public RegisterUserView(Main view){
        this.view = view;
    }

    public void RegisterUserSuccessMessage(){
        message.print("En användare har skapats");
    }
}
