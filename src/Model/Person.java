package Model;

public class Person {
    String name;
    String age;
    String occupation;
    int numberOfBankAccounts = 0;


    public Person(String n, String a, String o){
        this.name = n;
        this.age = a;
        this.occupation = o;
    }

    public Person(String n){
        this.name = n;
    }

    public Person(){
        this.name = "";
        this.age = "";
        this.occupation = "";
    }



    public String getName(){
        return this.name;
    }

    public String getAge(){
        return this.age;
    }

    public String getOccupation(){
        return this.occupation;
    }

    public void addextraBankAccount(){
        this.numberOfBankAccounts++;
    }

    @Override
    public String toString(){
        return String.format("%-8s %-8s %-8s",
                 getName(), getAge(), getOccupation());
    }
}
