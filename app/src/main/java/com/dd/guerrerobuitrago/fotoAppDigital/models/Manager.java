package com.dd.guerrerobuitrago.fotoAppDigital.models;

import java.util.ArrayList;

public class Manager {

    private static ArrayList<Person> personList;

    public Manager(){
        personList = new ArrayList<>();
        //personList.add(new Person(1, "Diego", "Guerrero", "d", "1", "photo"));
    }

    public static void addPerson(Person person){
        personList.add(person);
    }

    public static void removePerson(int index){ //static
        personList.remove(personList.get(index));
    }

    public static Person getPerson(int index){
        return personList.get(index);
    }

    public static ArrayList<Person> getPersonList(){
        return personList;
    }

    public static void setPersonList(ArrayList<Person> persons){
        personList = persons;
    }
}
