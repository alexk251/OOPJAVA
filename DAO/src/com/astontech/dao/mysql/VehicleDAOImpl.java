package com.astontech.dao.mysql;

import com.astontech.bo.Vehicle;
import com.astontech.dao.VehicleDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl extends MySQL implements VehicleDAO {
    @Override
    public Vehicle getVehicleById(int vehicleId) {
        Connect();
        Vehicle vehicle = null; //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = GET_VEHICLE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2,vehicleId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                //notesL HYDRATING AN OBJECT
                vehicle = HydrateObject(rs);

            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicle;
    }

    @Override
    public List<Vehicle> getVehicleList() {
        Connect();
        List<Vehicle> vehicleList = new ArrayList<Vehicle>(); //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = GET_VEHICLE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                //notesL HYDRATING AN OBJECT


                vehicleList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return vehicleList;
    }

    @Override
    public int insertVehicle(Vehicle vehicle) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,INSERT);
            cStmt.setInt(2,vehicle.getVehicleId());
            cStmt.setInt(3, vehicle.getYear());
            cStmt.setString(4,vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVIN());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setInt(7, vehicle.getIsPurchase());
            cStmt.setInt(8, vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10, vehicle.getVehicleModelId());


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
    public boolean updateVehicle(Vehicle vehicle) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,UPDATE);
            cStmt.setInt(2,vehicle.getVehicleId());
            cStmt.setInt(3, vehicle.getYear());
            cStmt.setString(4,vehicle.getLicensePlate());
            cStmt.setString(5, vehicle.getVIN());
            cStmt.setString(6, vehicle.getColor());
            cStmt.setInt(7, vehicle.getIsPurchase());
            cStmt.setInt(8, vehicle.getPurchasePrice());
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(vehicle.getPurchaseDate()));
            cStmt.setInt(10, vehicle.getVehicleModelId());


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
    public boolean deleteVehicle(int vehicleId) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_VEHICLE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,DELETE);
            cStmt.setInt(2,vehicleId);
            cStmt.setInt(3, 0);
            cStmt.setString(4,"");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setInt(7, 0);
            cStmt.setInt(8, 0);
            cStmt.setDate(9, new java.sql.Date(0));
            cStmt.setInt(10, 0);


            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    private static Vehicle HydrateObject(ResultSet rs) throws SQLException {
        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleId(rs.getInt(1));
        vehicle.setYear(rs.getInt(2));
        vehicle.setLicensePlate(rs.getString(3));
        vehicle.setVIN(rs.getString(4));
        vehicle.setColor(rs.getString(5));
        vehicle.setIsPurchase(rs.getInt(6));
        vehicle.setPurchasePrice(rs.getInt(7));
        vehicle.setPurchaseDate(rs.getDate(8));
        vehicle.setVehicleModelId(rs.getInt(9));

        return vehicle;
    }
}
