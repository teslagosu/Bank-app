package Model;

import Controller.BankController;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String nameOfBank;


public Bank(){
    this.nameOfBank = "";

}


public Bank(String name){
        this.nameOfBank = name;
    }


    public String getNameOfBank(){
        return this.nameOfBank;
    }
}
