package com.astontech.dao;

import com.astontech.bo.VehicleModel;

import java.util.List;

public interface VehicleModelDAO {
    //notes: GET METHODS
    public VehicleModel getVehicleModelById(int vehicleModelId);
    public List<VehicleModel> getVehicleModelList();

    //notes: EXECUTE METHODS
    public int insertVehicleModel(VehicleModel vehicleModel);
    public boolean updateVehicleModel(VehicleModel vehicleModel);
    public boolean deleteVehicleModel(int vehicleModelId);

}
