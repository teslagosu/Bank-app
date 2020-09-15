package Controller;

import Model.Person;
import View.PersonView;

import java.util.ArrayList;
import java.util.List;

public class PersonController {

    List<Person> personList = new ArrayList<>();
    PersonView view;
    MessageController mc = new MessageController();
    Person person;


    public PersonController(PersonView view, Person person){
        this.view = view;
        this.person = person;
    }

    public void addPersonToList(Person person){
        personList.add(person);
    }

    public Person createNewPersonObject(){
        mc.print("namn?");
        String name = mc.answer();
       /* mc.print("ålder?");
        String age = mc.answer();
        mc.print("yrke?");
        String occupation = mc.answer();
        */
        return new Person(name);
    }

    public Person getPerson(){
        return this.person;
    }


    public void printPersons(){
        System.out.println("----Personer----");
        personList.stream()
                .forEach(person -> mc.print(person.getName()));
    }
}
