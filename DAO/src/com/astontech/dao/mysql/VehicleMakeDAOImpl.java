package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.bo.Vehicle;
import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO {
    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake vehicleMake = null;
        try {
            String sp = GET_VEHICLEMAKE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, vehicleMakeId);
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                //notesL HYDRATING AN OBJECT
                vehicleMake = HydrateObject(rs);

            }

        } catch (SQLException ex) {
            logger.error(ex);
        }
        return vehicleMake;
    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {
        Connect();
        List<VehicleMake> vehicleMake = new ArrayList<VehicleMake>(); //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = GET_VEHICLEMAKE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                //notesL HYDRATING AN OBJECT


                vehicleMake.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleMake;
    }

    @Override
    public int insertVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLEMAKE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,INSERT);
            cStmt.setInt(2,vehicleMake.getVehicleMakeId());
            cStmt.setString(3, vehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(vehicleMake.getCreateDate()));

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
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLEMAKE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,UPDATE);
            cStmt.setInt(2,vehicleMake.getVehicleMakeId());
            cStmt.setString(3, vehicleMake.getVehicleMakeName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(vehicleMake.getCreateDate()));

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
    public boolean deleteVehicleMake(int vehicleMakeId) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLEMAKE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,DELETE);
            cStmt.setInt(2,vehicleMakeId);
            cStmt.setString(3, "");
            cStmt.setDate(4, new java.sql.Date(0));

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    private static VehicleMake HydrateObject(ResultSet rs) throws SQLException {
        VehicleMake vehicleMake = new VehicleMake();

        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleMakeName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));

        return vehicleMake;
    }
}
