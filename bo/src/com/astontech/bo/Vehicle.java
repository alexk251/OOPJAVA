package com.astontech.bo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle extends BaseBO implements Comparable{
    private int VehicleId;
    private VehicleModel VehicleModels;
    private VehicleMake VehicleMakes;
    private int VehicleModelId;
    private int Year;
    private String LicensePlate;
    private String VIN;
    private String Color;
    private int IsPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;

    public Vehicle(String licensePlate,int year, String vin,String color,VehicleModel vehicleModels, VehicleMake vehicleMakes ) {
        this.setLicensePlate(licensePlate);
        this.setYear(year);
        this.setVIN(vin);
        this.setColor(color);
        this.setVehicleModels(vehicleModels);
        this.setVehicleMakes(vehicleMakes);
    }

    public Vehicle() {};

    public  VehicleMake getVehicleMakes() {
        return VehicleMakes;
    }

    public void setVehicleMakes(VehicleMake vehicleMake) {
        this.VehicleMakes = vehicleMake;
    }

    public  VehicleModel getVehicleModels() {
        return VehicleModels;
    }

    public void setVehicleModels(VehicleModel vehicleModel) {
        this.VehicleModels = vehicleModel;
    }


    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getIsPurchase() {
        return IsPurchase;
    }

    public void setIsPurchase(int isPurchase) {
        IsPurchase = isPurchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public int compareTo(Object temp){
        Vehicle other = (Vehicle) temp;

        if(getYear() > other.getYear()) {
            return 1;
        } else if(getYear() < other.getYear()) {
            return -1;
        } else
            return 0;
    }

    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }
}
