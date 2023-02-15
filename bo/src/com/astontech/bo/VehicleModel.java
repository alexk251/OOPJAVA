package com.astontech.bo;

public class VehicleModel extends BaseBO{
    private int VehicleModelId;
    private VehicleMake vehicleMake;

    private int vehicleMakeId;
    private String VehicleModelName;

    public VehicleModel() {};

    public VehicleModel(String vehicleModelName) {
        this.setVehicleModelName(vehicleModelName);
    };

    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }


    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    public VehicleMake getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(VehicleMake vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    @Override
    public String toString() {
        return this.VehicleModelName;
    }

    public int getVehicleMakeId() {
        return vehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        this.vehicleMakeId = vehicleMakeId;
    }
}
