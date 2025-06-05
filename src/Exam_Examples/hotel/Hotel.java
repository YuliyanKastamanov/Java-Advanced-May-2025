package Exam_Examples.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {


    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(this.roster.size() < capacity){
            this.roster.add(person);
        }
    }


    public boolean remove(String name){
        boolean isSuccessfullyRemoved = false;

        for (Person person : roster){
            if(person.getName().equals(name)){
                roster.remove(person);
                isSuccessfullyRemoved = true;
                break;
            }
        }
        return isSuccessfullyRemoved;
    }


    public Person getPerson(String name, String hometown){
        Person personToReturn = null;

        for (Person person : roster){

            if(person.getName().equals(name) && person.getHometown().equals(hometown)){
                personToReturn = person;
                break;
            }
        }
        return personToReturn;
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("The people in the Exam_Examples.hotel %s are:%n", this.name));

        for (Person person : this.roster){
            builder.append(person.toString()).append(System.lineSeparator());
        }

        return builder.toString();
    }



}

