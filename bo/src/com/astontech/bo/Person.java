package com.astontech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import common.helpers.*;

public class Person extends BaseBO implements Comparable {

    //region Properties
    //PersonId
    private int PersonId;
    //Title
    private String Title;
    //First Name
    private String FirstName;
    //Last Name
    private String LastName;
    //DisplayFirstName
    private String DisplayFirstName;
    //Gender
    private String Gender;
    // List of Email Objects
    private List<Email> Emails;

    private String MiddleName;
    private Date BirthDate;
    private String SSN;

    //region Constructors
    public Person() {
        this.setEmails(new ArrayList<>());
    }

    public Person(int personId, String title, String firstName, String lastName) {this.setPersonId(personId);this.setTitle(title);this.setFirstName(firstName);this.setLastName(lastName);}
    //getters setters
    public void setPersonId(int personId) {
        this.PersonId = personId;
    }

    public int getPersonId() {
        return this.PersonId;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setDisplayFirstName(String displayFirstName) {
        this.DisplayFirstName = DisplayFirstName;
    }

    public String getDisplayFirstName() {
        return this.DisplayFirstName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getGender() {
        return this.Gender;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }
    //CUSTOM METHODS
    //notes: this will become an extension method.


    public String GetFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName))
            return "No Name Set";
        else {
            if (StringHelper.isNullOrEmpty(this.FirstName))
                return this.LastName;
            else if (StringHelper.isNullOrEmpty(this.LastName))
                return this.FirstName;
            else
                return this.FirstName + " " + this.LastName;
        }

    }


    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> emails) {
        Emails = emails;
    }

    public int compareTo(Object temp){
        Person other = (Person) temp;

        if(getPersonId() > other.getPersonId()) {
            return 1;
        } else if(getPersonId() < other.getPersonId()) {
            return -1;
        } else
            return 0;
    }


}
