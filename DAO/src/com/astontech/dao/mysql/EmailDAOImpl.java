package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.dao.EmailDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmailDAOImpl extends MySQL implements EmailDAO {


    @Override
    public Email getEmailById(int emailId) {
        Connect();
        Email email = null;
        try {
            String sp = GET_EMAIL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, emailId);;
            ResultSet rs = cStmt.executeQuery();

            if (rs.next()) {
                //notesL HYDRATING AN OBJECT
                email = HydrateObject(rs);

            }

        } catch (SQLException ex) {
            logger.error(ex);
        }
        return email;
    }

    @Override
    public List<Email> getEmailList() {
        Connect();
        List<Email> emailList = new ArrayList<Email>(); //not instantiated because if no records returned we don't want to use memory.
        try {
            String sp = GET_EMAIL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while (rs.next()) {
                //notesL HYDRATING AN OBJECT


                emailList.add(HydrateObject(rs));
            }

        } catch (SQLException ex) {
            logger.error(ex);
        }

        return emailList;
    }

    @Override
    public int insertEmail(Email email) {
            Connect();
            int id = 0;
            try {
                String sp = EXEC_EMAIL;
                CallableStatement cStmt = connection.prepareCall(sp);

                cStmt.setInt(1,INSERT);
                cStmt.setInt(2,email.getEmailId());
                cStmt.setInt(3, email.getEntityTypeId());
                cStmt.setInt(4,email.getEmployeeId());
                cStmt.setString(5, email.getEmailAddress());

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
    public boolean updateEmail(Email email) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_EMAIL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,UPDATE);
            cStmt.setInt(2,email.getEmailId());
            cStmt.setInt(3, email.getEntityTypeId());
            cStmt.setInt(4,email.getEmployeeId());
            cStmt.setString(5, email.getEmailAddress());

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
    public boolean deleteEmail(int emailId) {
        Connect();
        int id = 0;
        try {
            String sp = EXEC_EMAIL;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1,DELETE);
            cStmt.setInt(2,emailId);
            cStmt.setInt(3, 0);
            cStmt.setInt(4,0);
            cStmt.setString(5, "");

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id > 0;
    }

    private static Email HydrateObject(ResultSet rs) throws SQLException {
        Email email = new Email();

        email.setEmailId(rs.getInt(1));
        email.setEmailAddress(rs.getString(2));
        email.setEmployeeId(rs.getInt(3));
        email.setEntityTypeId(rs.getInt(4));

//        a.EmailId,
//                a.EmailAddress,
//                a.EmployeeId,
//                a.EntityTypeId

        return email;
    }
}
