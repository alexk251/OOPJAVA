package com.astontech.bo.interfaces;

public class Site implements ILocation{

    private int ConferenceRooms;
    private int Offices;
    private int Cubicles;
    private int TrainingDesks;
    private int CoffeeMachine;
    private String SiteName;

    //GETTERS/SETTERS
    public int getConferenceRooms() {
        return ConferenceRooms;
    }

    public void setConferenceRooms(int conferenceRooms) {
        ConferenceRooms = conferenceRooms;
    }

    public int getOffices(int offices) {
        return Offices;
    }

    public void setOffices(int offices) {
        Offices = offices;
    }

    public int getCubicles() {
        return Cubicles;
    }

    public void setCubicles(int cubicles) {
        Cubicles = cubicles;
    }

    public int getTrainingDesks() {
        return TrainingDesks;
    }

    public void setTrainingDesks(int trainingDesks) {
        TrainingDesks = trainingDesks;
    }

    public int getCoffeeMachine() {
        return CoffeeMachine;
    }

    public void setCoffeeMachine(int coffeeMachine) {
        CoffeeMachine = coffeeMachine;
    }

    public String getSiteName() {
        return SiteName;
    }

    public void setSiteName(String siteName) {
        SiteName = siteName;
    }

    @Override
    public int numberOfWorkspaces() {
        return (this.Cubicles + this.getOffices(6) + this.TrainingDesks);
    }

    @Override
    public boolean canHaveMeetings() {
        if (this.ConferenceRooms > 0)
            return true;
        else
            return false;
    }

    @Override
    public String getLocationName() {
        return this.SiteName;
    }

    @Override
    public boolean hasCoffee() {
        if(this.CoffeeMachine > 0)
            return true;
        else
            return false;
    }
}
