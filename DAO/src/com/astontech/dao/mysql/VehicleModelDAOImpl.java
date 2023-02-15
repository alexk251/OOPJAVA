package com.astontech.dao.mysql;

import com.astontech.bo.VehicleModel;
import com.astontech.dao.VehicleModelDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleModelDAOImpl extends MySQL implements VehicleModelDAO {
    @Override
    public VehicleModel getVehicleModelById(int vehicleModelId) {
        Connect();
        VehicleModel vehicleModel = null;
        try {
            String sp = GET_VEHICLEMODEL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleModelId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                //notesL HYDRATING AN OBJECT
                vehicleModel = HydrateObject(rs);

            }

        } catch (SQLException ex) {
            logger.error(ex);
        }
        return vehicleModel;
    }

    @Override
    public List<VehicleModel> getVehicleModelList() {
        Connect();
        List<VehicleModel> vehicleModel = new ArrayList<VehicleModel>(); //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = GET_VEHICLEMODEL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                //notesL HYDRATING AN OBJECT


                vehicleModel.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleModel;
    }

    @Override
    public int insertVehicleModel(VehicleModel vehicleModel) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLEMODEL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,INSERT);
            cStmt.setInt(2,vehicleModel.getVehicleModelId());
            cStmt.setString(3, vehicleModel.getVehicleModelName());
            cStmt.setInt(4, vehicleModel.getVehicleMakeId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id;
    }

    @Override
    public boolean updateVehicleModel(VehicleModel vehicleModel) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLEMODEL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,UPDATE);
            cStmt.setInt(2,vehicleModel.getVehicleModelId());
            cStmt.setString(3, vehicleModel.getVehicleModelName());
            cStmt.setInt(4, vehicleModel.getVehicleMakeId());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    @Override
    public boolean deleteVehicleModel(int vehicleModelId) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLEMODEL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,INSERT);
            cStmt.setInt(2,vehicleModelId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    private static VehicleModel HydrateObject(ResultSet rs) throws SQLException {
        VehicleModel vehicleModel = new VehicleModel();

        vehicleModel.setVehicleModelId(rs.getInt(1));
        vehicleModel.setVehicleModelName(rs.getString(2));
        vehicleModel.setVehicleMakeId(rs.getInt(3));

        return vehicleModel;
    }
}
