package com.astontech.bo.interfaces;

import com.astontech.bo.Person;

public class Inital implements IInitals {

    private Person Name;


    public Person getName() {
        return Name;
    }

    public void setName(Person name) {
        Name = name;
    }

    @Override
    public String getFirstInital() {
        String firstName = this.Name.getFirstName();
        return firstName.substring(0,0);
    }

    @Override
    public String getLastInital() {
       String lastName = this.Name.getLastName();
        return lastName.substring(lastName.length()-1,lastName.length()-1);
    }

}
