package com.astontech.dao.mysql;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQL {
    protected static String dbHost = "localhost";
    protected static String dbName = "astonengineer";
    protected static String dbUser = "consoleUser";
    protected static String dbPass = "Cheese123";
    protected static String useSSL = "false";
    protected static String procBod = "true";

    protected static Connection connection = null;

    final static Logger logger = Logger.getLogger(MySQL.class);
    protected static final int GET_BY_ID = 10;
    protected static final int GET_COLLECTION = 20;
    protected static final int INSERT = 10;
    protected static final int UPDATE = 20;
    protected static final int DELETE = 30;

    static final String GET_PERSON = "{call GetPerson(?,?)}";
    static final String EXEC_PERSON = "{call ExecPerson(?,?,?,?,?,?,?)}";
    static final String GET_EMAIL = "{call GetEmail(?,?)}";
    static final String EXEC_EMAIL = "{call ExecEmail(?,?,?,?,?)}";
    static final String GET_EMPLOYEE = "{call GetEmployee(?,?)}";
    static final String EXEC_EMPLOYEE = "{call ExecEmployee(?,?,?,?,?,?,?)}";
    static final String GET_PHONE = "{call GetPhone(?,?)}";
    static final String EXEC_PHONE = "{call ExecPhone(?,?,?,?,?,?,?)}";
    static final String GET_VEHICLE = "{call GetVehicle(?,?)}";
    static final String EXEC_VEHICLE = "{call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";
    static final String GET_VEHICLEMAKE = "{call GetVehicleMake(?,?)}";
    static final String EXEC_VEHICLEMAKE = "{call ExecVehicleMake(?,?,?,?)}";
    static final String GET_VEHICLEMODEL = "{call GetVehicleModel(?,?)}";
    static final String EXEC_VEHICLEMODEL = "{call ExecVehicleModel(?,?,?,?)}";

    protected static void Connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found" + ex);
        }

        logger.info("mySQL Driver Registered");


        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?autoReconnect=true&useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        } catch (
                SQLException ex) {
            logger.error("Connection failed!" + ex);
        }

        if (connection != null) {
            logger.info("Successfully connected");
        } else {
            logger.info("Connection failed!");
        }
    }
}
