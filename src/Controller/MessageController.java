package Controller;

import java.util.Scanner;

public class MessageController {

    public void print(String s){
        System.out.println(s);
    }
    public void printString(String text, String value) {
        System.out.printf(text+" %s%n",value);
    }
    public void printInt(String text, int value) {
        System.out.printf(text+" %d%n",value);
    }
    public void printFloat(String text, float value) {
        System.out.printf(text+" %.2f%n",value);
    }

    public String answer (){
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        return answer;
    }

    public int choice(){
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        return choice;
    }
}
