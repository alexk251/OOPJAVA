package com.astontech.bo;

import java.util.Date;

public class Address extends Person{

    private int AddressId;
    private int ClientId;
    private int PersonId;
    private int EntityTypeId;
    private String AddressNumber;
    private String Street;
    private String Street02;
    private String City;
    private int StateId;
    private int CountryId;
    private Date DateCreate;

    //Constructors
    public Address() {}

    public Address(String addressNumber, String street) {
        this.setAddressNumber(addressNumber);
        this.setStreet(street);
    }

    //custom Methods
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public String GetAddress() {
        if(isNullOrEmpty(this.AddressNumber) && isNullOrEmpty(this.Street))
            return "No Name Set";
        else {
            if (isNullOrEmpty(this.AddressNumber))
                return this.Street;
            else if (isNullOrEmpty(this.Street))
                return this.AddressNumber;
            else
                return this.AddressNumber + " " + this.Street;
        }

    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    @Override
    public int getPersonId() {
        return PersonId;
    }

    @Override
    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        AddressNumber = addressNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet02() {
        return Street02;
    }

    public void setStreet02(String street02) {
        Street02 = street02;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }
}
