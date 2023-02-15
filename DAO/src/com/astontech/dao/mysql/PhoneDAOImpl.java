package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.bo.Employee;
import com.astontech.bo.Phone;
import com.astontech.dao.PhoneDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDAOImpl extends MySQL implements PhoneDAO {
    @Override
    public Phone getPhoneById(int phoneId) {
        Connect();
        Phone phone = null;
        try {
            String sp = GET_PHONE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_BY_ID);
            cStmt.setInt(2,phoneId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                //notesL HYDRATING AN OBJECT
                phone = HydrateObject(rs);

            }

        } catch (SQLException ex) {
            logger.error(ex);
        }
        return phone;
    }

    @Override
    public List<Phone> getPhoneList() {
        Connect();
        List<Phone> phoneList = new ArrayList<Phone>(); //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = GET_PHONE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,GET_COLLECTION);
            cStmt.setInt(2,0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                //notesL HYDRATING AN OBJECT


                phoneList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return phoneList;
    }

    @Override
    public int insertPhone(Phone phone) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_PHONE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,INSERT);
            cStmt.setInt(2,phone.getPhoneId());
            cStmt.setInt(3, phone.getEntityTypeId());
            cStmt.setInt(4,phone.getClientId());
            cStmt.setInt(5, phone.getPersonId());
            cStmt.setInt(6, phone.getPhoneNumber());
            cStmt.setInt(7, phone.getPhoneNumberPost());


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
    public boolean updatePhone(Phone phone) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_PHONE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,UPDATE);
            cStmt.setInt(2,phone.getPhoneId());
            cStmt.setInt(3, phone.getEntityTypeId());
            cStmt.setInt(4,phone.getClientId());
            cStmt.setInt(5, phone.getPersonId());
            cStmt.setInt(6, phone.getPhoneNumber());
            cStmt.setInt(7, phone.getPhoneNumberPost());


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
    public boolean deletePhone(int phoneId) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_PHONE;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,DELETE);
            cStmt.setInt(2,phoneId);
            cStmt.setInt(3, 0);
            cStmt.setInt(4,0);
            cStmt.setInt(5, 0);
            cStmt.setInt(6, 0);
            cStmt.setInt(7,0);


            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    private static Phone HydrateObject(ResultSet rs) throws SQLException {
        Phone phone = new Phone();

        phone.setPhoneId(rs.getInt(1));
        phone.setEntityTypeId(rs.getInt(2));
        phone.setClientId(rs.getInt(3));
        phone.setPersonId(rs.getInt(4));
        phone.setAreaCode(rs.getInt(5));
        phone.setPhoneNumberPost(rs.getInt(6));
        phone.setPhoneNumberPost((rs.getInt(7)));

        return phone;
    }
}
