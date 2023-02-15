package com.astontech.console;

import com.astontech.bo.*;
import com.astontech.bo.interfaces.Home;
import com.astontech.bo.interfaces.ILocation;
import com.astontech.bo.interfaces.Site;
import com.astontech.dao.*;
import com.astontech.dao.mysql.*;
import common.helpers.MathHelper;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;
import java.util.Date;

public class Main {

    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
//        try {
//            LessonExceptions();
//        } catch (Exception ex) {
//            System.out.println(ex.toString());
//        }
//        LessonFizzBuzzLAB();
//        LessonCalculatorLAB();
        //Test myTest = new Test();
        //LessonInheritance();
        //LessonMethods();
        //LessonObjectsLAB();
        //LessonCollections();
        //LessonComplexProperties();
        //LessonCollectionsLAB();
        //LessonInstanceVsStatic();
        //LessonPolymorphism();
        //LessonHash();
        //LessonValueVsRef();
        //LessonInterfaceTest();
        //LessonLists();
        //LessonLogging();
        //LAB5OOP();
        //LessonDBConnection();
        //LessonExecQuery();
        //LessonGetStoredProc();
        //LessonDAO();
        //DBConnectionLAB();
        //DAOLAB1();
        //LessonDAOInsert();
        //LessonDAOUpdate();
        //LessonDAODelete();
        //LAB2DAOEmployeeEmail();
        //LessonReflectionAndGenerics(Entity.class);
    }

    private static void LessonBoxUnbocingCasting() {
        //notes: BOXING: act of converting a value type to a ref type
        //       UNBOXING converting a ref type to a value type.

        //notes: boxing
        String x = "10";
        Object o = x;
        LessonReflectionAndGenerics(o.getClass());

        //notes: unboxing

    }

    private static <T> void LessonReflectionAndGenerics(Class<T> genericClass){


        logger.info("Full Name: " + genericClass.getName());
        logger.info(("Simple Name: " + genericClass.getSimpleName()));
        for(Field field : genericClass.getDeclaredFields()) {
            logger.info("Field: " + field.getName() + " - Type: " + field.getType());
        }
        for(Method method : genericClass.getMethods()) {
            logger.info("Method: " + method.getName());
        }

    }
    private static void LAB2DAOVehicle(){
        //Vehicle INSERT TEST
        Vehicle vehicle = new Vehicle();
        vehicle.setYear(1990);
        vehicle.setLicensePlate("42069");
        vehicle.setVIN("175328491073820");
        vehicle.setColor("GreenDeath");
        vehicle.setIsPurchase(0);
        vehicle.setPurchasePrice(1000);
        vehicle.setPurchaseDate(new Date());
        vehicle.setVehicleModelId(1);

        VehicleDAO vehicleDAO = new VehicleDAOImpl();
        int id = vehicleDAO.insertVehicle(vehicle);

        logger.info("New Vehicle Record Inserted. ID = " + id);

        //Vehicle UPDATE TEST

        VehicleDAO vehicleDAO1 = new VehicleDAOImpl();

        Vehicle vehicle1 = vehicleDAO1.getVehicleById(id);
        vehicle1.setColor("Red");

        logger.info(vehicle1.getColor());

        if (vehicleDAO1.updateVehicle(vehicle1))
            logger.info("Vehicle Updated Successfully.");
        else
            logger.info("Vehicle Update Failed!");

        //Employee Vehicle TEST
        VehicleDAO vehicleDAO2 = new VehicleDAOImpl();

        if (vehicleDAO2.deleteVehicle(id))
            logger.info("Vehicle Deleted Successfully.");
        else
            logger.info("Vehicle Delete Failed");

    }

    private static void LAB2DAOMake(){
        //Make INSERT TEST
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeName("Toyota");
        vehicleMake.setCreateDate(new Date());

        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImpl();
        int id = vehicleMakeDAO.insertVehicleMake(vehicleMake);

        logger.info("New Make Record Inserted. ID = " + id);

        //Make UPDATE TEST

        VehicleMakeDAO vehicleMakeDAO1 = new VehicleMakeDAOImpl();

        VehicleMake vehicleMake1 = vehicleMakeDAO1.getVehicleMakeById(id);
        vehicleMake1.setCreateDate(new Date());

        logger.info(vehicleMake1.getCreateDate());

        if (vehicleMakeDAO1.updateVehicleMake(vehicleMake))
            logger.info("Make Updated Successfully.");
        else
            logger.info("Make Update Failed!");

        //Make Delete TEST

        VehicleMakeDAO vehicleMakeDAO2 = new VehicleMakeDAOImpl();

        if (vehicleMakeDAO2.deleteVehicleMake(id))
            logger.info("Make Deleted Successfully.");
        else
            logger.info("Make Delete Failed");
    }

    private static void LAB2DAOModel(){
        //Model INSERT TEST
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setVehicleMakeId(1);
        vehicleModel.setVehicleModelName("Highlander");

        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();
        int id = vehicleModelDAO.insertVehicleModel(vehicleModel);

        logger.info("New Model Record Inserted. ID = " + id);

        //Model UPDATE TEST

        VehicleModelDAO vehicleModelDAO1 = new VehicleModelDAOImpl();

        VehicleModel vehicleModel1 = vehicleModelDAO1.getVehicleModelById(id);
        vehicleModel1.setVehicleModelName("Rav 4");

        logger.info(vehicleModel1.getVehicleModelName());

        if (vehicleModelDAO1.updateVehicleModel(vehicleModel))
            logger.info("MOdel Updated Successfully.");
        else
            logger.info("Model Update Failed!");

        //Model Delete TEST

        VehicleModelDAO vehicleModelDAO2 = new VehicleModelDAOImpl();

        if (vehicleModelDAO2.deleteVehicleModel(id))
            logger.info("Model Deleted Successfully.");
        else
            logger.info("Model Delete Failed");

    }

    private static void LAB2DAOPhone(){
        //Phone INSERT TEST
        Phone phone = new Phone();
        phone.setEntityTypeId(1);
        phone.setClientId(1);
        phone.setPersonId(1);
        phone.setPhoneNumber(8029482);
        phone.setPhoneNumberPost(612);

        PhoneDAO phoneDAO = new PhoneDAOImpl();
        int id = phoneDAO.insertPhone(phone);

        logger.info("New Phone Record Inserted. ID = " + id);

        //Phone UPDATE TEST

        PhoneDAO phoneDAO1 = new PhoneDAOImpl();

        Phone phone1 = phoneDAO1.getPhoneById(id);
        phone1.setPhoneNumber(2221234);

        logger.info(phone1.getPhoneNumber());

        if (phoneDAO1.updatePhone(phone1))
            logger.info("Phone Updated Successfully.");
        else
            logger.info("Phone Update Failed!");

        //Phone Delete TEST

        PhoneDAO phoneDAO2 = new PhoneDAOImpl();

        if (phoneDAO2.deletePhone(id))
            logger.info("Phone Deleted Successfully.");
        else
            logger.info("Phone Delete Failed");

    }

    private static void LAB2DAOEmployeeEmail(){
        //Employee INSERT TEST
        Employee employee = new Employee();
        employee.setHireDate(new Date());
        employee.setTermDate(new Date());
        employee.setBirthDate(new Date());
        employee.setPersonId(10);
        employee.setCreateDate(new Date());

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        int id = employeeDAO.insertEmployee(employee);

        logger.info("New Employee Record Inserted. ID = " + id);

        //Employee UPDATE TEST

        EmployeeDAO employeeDAOU = new EmployeeDAOImpl();

        Employee employee1 = employeeDAOU.getEmployeeById(id);
        employee1.setBirthDate(new Date());

        logger.info(employee1.getBirthDate());

        if (employeeDAOU.updateEmployee(employee))
            logger.info("Employee Updated Successfully.");
        else
            logger.info("Employee Update Failed!");

        //Employee Delete TEST

        EmployeeDAO employeeDAO1 = new EmployeeDAOImpl();

        if (employeeDAO1.deleteEmployee(id))
            logger.info("Employee Deleted Successfully.");
        else
            logger.info("Employee Delete Failed");

        //EMAIL INSERT TEST
        Email email = new Email();
        email.setEntityTypeId(1);
        email.setEmployeeId(1);
        email.setEmailAddress("BillyBobThorton@bob.com");

        EmailDAO emailDAO = new EmailDAOImpl();
        int id2 = emailDAO.insertEmail(email);

        logger.info("New EMAIL Record Inserted. ID = " + id2);

        //EMAIL UPDATE TEST

        EmailDAO emailDAOU = new EmailDAOImpl();

        Email email1 = emailDAOU.getEmailById(10);
        email1.setEmailAddress("SuperBob@email.com");

        logger.info(email1.getEmailAddress());

        if (emailDAOU.updateEmail(email1))
            logger.info("Email Updated Successfully.");
        else
            logger.info("Email Update Failed!");

        //EMAIL DELETE TEST

        EmailDAO emailDAO1 = new EmailDAOImpl();

        if (emailDAO1.deleteEmail(id2))
            logger.info("Email Deleted Successfully.");
        else
            logger.info("Email Delete Failed");
    }

    private static void LessonDAODelete(){
        PersonDAO personDAO = new PersonDAOImpl();

        if (personDAO.deletePerson(49))
            logger.info("Person Deleted Successfully.");
        else
            logger.info("Person Delete Failed");

    }

    private static void LessonDAOUpdate() {
        PersonDAO personDAO = new PersonDAOImpl();

        Date date = new Date();

        Person person = personDAO.getPersonById(10);
        person.setMiddleName("UPDATED!!!");
        person.setBirthDate(date);
        person.setSSN("xxx-xx-xxxx");

        logger.info(person.getBirthDate());

        if (personDAO.updatePerson(person))
            logger.info("Person Updated Successfully.");
        else
            logger.info("Person Update Failed!");
    }

    private static void LessonDAOInsert() {
        Person person = new Person();
        person.setFirstName("Tony");
        person.setMiddleName("IronMan");
        person.setLastName("Stark");
        person.setBirthDate(new Date());
        person.setSSN("yyy-yy-yyyy");

        PersonDAO personDAO = new PersonDAOImpl();
        int id = personDAO.insertPerson(person);

        logger.info("New Person Record Inserted. ID = " + id);
    }

    private static void DAOLAB1() {
        EmailDAO emailDAO = new EmailDAOImpl();
        List<Email> emailList = emailDAO.getEmailList();

        System.out.println("=======================================");

        for(Email email : emailList) {
            System.out.println(email.getEmailId() +" "+ email.getEmailAddress());
        }

//        System.out.println("=======================================");
//
//        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
//        List<Employee> employeeList = employeeDAO.getEmployeeList();
//
//        System.out.println("=======================================");
//
//        for(Employee employee : employeeList) {
//            System.out.println(employee.getEmployeeId() +" "+ employee.getDisplayFirstName());
//        }
//
//        System.out.println("=======================================");
//
//        PhoneDAO phoneDAO = new PhoneDAOImpl();
//        List<Phone> phoneList = phoneDAO.getPhoneList();
//
//        System.out.println("=======================================");
//
//        for(Phone phone : phoneList) {
//            System.out.println(phone.getPhoneId() +" "+ phone.getPhoneNumber());
//        }
//
//        System.out.println("=======================================");
//
//        VehicleDAO vehicleDAO = new VehicleDAOImpl();
//        List<Vehicle> vehicleList = vehicleDAO.getVehicleList();
//
//        System.out.println("=======================================");
//
//        for(Vehicle vehicle : vehicleList) {
//            System.out.println(vehicle.getVehicleId() +" "+ vehicle.getYear() + " "+ vehicle.getColor() + " "+ vehicle.getLicensePlate() + " "+ vehicle.getVIN());
//        }
//
//        System.out.println("=======================================");
//
//        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImpl();
//        List<VehicleModel> vehicleModelList = vehicleModelDAO.getVehicleModelList();
//
//        System.out.println("=======================================");
//
//        for(VehicleModel vehicleModel : vehicleModelList) {
//            System.out.println(vehicleModel.getVehicleModelId() +" "+ vehicleModel.getVehicleModelName());
//        }
//
//        System.out.println("=======================================");
//
//        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImpl();
//        List<VehicleMake> vehicleMakeList = vehicleMakeDAO.getVehicleMakeList();
//
//        System.out.println("=======================================");
//
//        for(VehicleMake vehicleMake : vehicleMakeList) {
//            System.out.println(vehicleMake.getVehicleMakeId() +" "+ vehicleMake.getVehicleMakeName());
//        }
//
//        System.out.println("=======================================");
    }

    private static void LessonDAO() {
        //region CREATE MENU
        PersonDAO personDAO = new PersonDAOImpl(); //amend in next lesson
        List<Person> personList = personDAO.getPersonList();

        System.out.println("=======================================");

        for(Person person : personList) {
            System.out.println(person.getPersonId() +" "+ person.getLastName() +", "+ person.getFirstName());
        }

        System.out.println("=======================================");
        //endregion

        //region PROMPT USER
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Select a Person from list: ");
        String personId = scanner.nextLine();

        //endregion

        //region GET PERSON DETAILS
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));

        System.out.println("---- PERSON DETAILS ----");
        System.out.println("Full Name: " + personDetail.getFirstName() + " "+ personDetail.getLastName());
        System.out.println("DOB: " + personDetail.getBirthDate());
        System.out.println("SSN: " + personDetail.getSSN());

        //endregion
    }

    private static void LessonGetStoredProc() {
        Connection conn = LessonDBConnection();
        try{
            String sp = "{call GetPerson(?,?)}";
            CallableStatement cStmt = conn.prepareCall(sp);

            cStmt.setInt(1, 20);
            cStmt.setInt(2,1);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                logger.info(rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3));
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static void LessonExecQuery() {
        Connection conn = LessonDBConnection();
        try {
            Statement statement = conn.createStatement();
            String sql = "select PersonId, FirstName, LastName from person;";

            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);

                logger.info("PersonId: "+ personId + " FirstName: " + firstName + " - LastName: "+ lastName);
            }
            conn.close();

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

    }

    private static Connection DBConnectionLAB() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            logger.error("SQLSERVER Driver not found" + ex);
            return null;
        }

        logger.info("SQLSERVER Driver Registered");
        Connection conn = null;


        try {
            String serverName = "G1NRMQ2";
            String dbName = "AstonEngineer";
            String url = "jdbc:sqlserver://" +serverName + ":1433;DatabaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";

            String user = "ASTONTECH\\Alex.Kim";
            String pass = "";
            conn = DriverManager.getConnection(url,user,pass);

            try {
                Statement statement = conn.createStatement();
                String sql = "select PersonId, FirstName, LastName from person;";

                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    int personId = rs.getInt(1);
                    String firstName = rs.getString(2);
                    String lastName = rs.getString(3);

                    logger.info("PersonId: "+ personId + " FirstName: " + firstName + " - LastName: "+ lastName);
                }
                conn.close();

            } catch (SQLException sqlEx) {
                logger.error(sqlEx);
            }

        } catch (SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }

        if (conn != null) {
            logger.info("Successfully connected");
            return conn;
        } else {
            logger.info("Connection failed!");
            return null;
        }

    }

    private static Connection LessonDBConnection() {
        String dbHost = "localhost";
        String dbName = "astonengineer";
        String dbUser = "consoleUser";
        String dbPass = "Cheese123";
        String useSSL = "false";
        String procBod = "true";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found" + ex);
            return null;
        }

        logger.info("mySQL Driver Registered");
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://"+dbHost+":3306/"+dbName+"?autoReconnect=true&useSSL="+useSSL+"&noAccessToProcedureBodies=" + procBod,dbUser,dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed!" + ex);
            return null;
        }

        if (connection != null) {
            logger.info("Successfully connected");
            return connection;
        } else {
            logger.info("Connection failed!");
            return null;
        }
    }

    private static void LAB5OOP() {
    }

    private static void LessonLogging() {
        //notes: levels of logging.

        //testing levels
        logger.debug("This is a DEBUG log message");
        logger.info("This is an INFO log message");

        //Production levels
        logger.warn("This is a WARN log message");
        logger.error("This is an ERROR log message");
        logger.fatal("This is a FATAL log message");

        //notes: log an exception

        try {
            int i = 10 / 0;
        } catch (ArithmeticException ex) {
            logger.error("An exception occured: " + ex);
        }
    }

    private static void LessonInterfaceTest() {
        Site MN010 = new Site();
        MN010.setSiteName("MN010");
        MN010.setCoffeeMachine(2);
        MN010.setConferenceRooms(1);
        MN010.setCubicles(8);
        MN010.getOffices(6);
        MN010.setTrainingDesks(36);

        Home BipsHouse = new Home();
        BipsHouse.setAddress("1 Main St");
        BipsHouse.setOwner(new Employee("Bipin", "Butala"));

        LessonInterfaces(MN010);
        LessonInterfaces(BipsHouse);
    }

    private static void LessonInterfaces(ILocation Ilocation){
        System.out.println("=========================");
        System.out.println("LocationName: " + Ilocation.getLocationName());
        System.out.println("Can Have Meetings: " + Ilocation.canHaveMeetings());
        System.out.println("Number of Workspaces: " + Ilocation.numberOfWorkspaces());
        System.out.println("Has Coffee!: " + Ilocation.hasCoffee());
    }

    public static void  LessonValueVsRef() {
        //notes: reference type
        Employee firstEmp = new Employee();
        firstEmp.setFirstName("Bipin");

        Employee secondEmp = firstEmp;
        firstEmp.setFirstName("Dean");
        secondEmp.setFirstName("Bob");


        //notes: value types
        int firstInt = 10;
        int secondInt = firstInt;

        firstInt = 20;

        System.out.println(secondInt);
    }

    public static void LessonHash() {
        //todo: HashTable
        /*
            1) does NOT allow null for either key or value
            2) synchronized, thread safe but performance is decreased
         */
        System.out.println("---HASH TABLE---");

        Hashtable<Integer, String> firstHashTable = new Hashtable<>();
        firstHashTable.put(1,"Inheritence");
        firstHashTable.put(2,"Polymorphism");
        firstHashTable.put(3,"Abstraction");
        firstHashTable.put(4,"Encapsulation");

        System.out.println("value from give key: " + firstHashTable.get(3));

        for(Integer key : firstHashTable.keySet()) {
            System.out.println("key: " + key + " - value: " + firstHashTable.get(key));
        }


        System.out.println("----------------");

        //todo: HashMap
        /*
            1) DOES allow null for either key or value
            2) un-synchronized, not thread safe better performance
         */
        System.out.println("---HASH MAP---");

        HashMap<Integer,String> firstHashMap = new HashMap<>();
        firstHashMap.put(1,"Inheritence");
        firstHashMap.put(2,"Polymorphism");
        firstHashMap.put(3,"Abstraction");
        firstHashMap.put(4,"Encapsulation");
        firstHashMap.put(5, null);

        for(Integer key : firstHashMap.keySet()) {
            System.out.println("key: " + key + " - value: " + firstHashMap.get(key));
        }

        System.out.println("----------------");

        //todo: HashSet
        /*
            1) built in mechanism for duplicates
            2) used for where you want to maintain a unique list
         */
        System.out.println("---HASH SET---");
        HashSet<String> oopPrinc = new HashSet<>();
        oopPrinc.add("Inheritance");
        oopPrinc.add("Encapsulation");

        if(oopPrinc.contains("Encapsulation"))
            System.out.println("Value exists");
        else
            System.out.println("Value does not exist");

        for(String s : oopPrinc) {
            System.out.println(s);
        }
    }


    private static void LessonPolymorphism() {
        //notes: compile time polymorphism - overloaded

        //notes: runtime polymorphism - override
        BaseBO baseBO = new BaseBO();
        System.out.println(baseBO.test_method());

        EntityType entityType = new EntityType();
        System.out.println((entityType.test_method()));

    }

    private static void LessonInstanceVsStatic() {
        MathHelper InstanceOfMathClass = new MathHelper();



        System.out.println(MathHelper.E);

        System.out.println(MathHelper.PI);

        System.out.println(MathHelper.square(4));

        Main instanceOfMain = new Main();
        instanceOfMain.LessonCollections();
    }

    private static void LessonCollectionsLAB() {
        //create vehicle list array
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        //create indiviual vehicles and vehicle makes and models
        //Vehicles
        Vehicle Vehicle1 = new Vehicle("BOA123",2003,"123123","Blue", new VehicleModel("Toyota"), new VehicleMake("Highlander"));
        Vehicle Vehicle2 = new Vehicle("BOA124",2004,"123124","Red", new VehicleModel("Ford"),new VehicleMake("Focus"));
        Vehicle Vehicle3 = new Vehicle("BOA125",2005,"123125","Silver", new VehicleModel("Chevrolet"),new VehicleMake("FireBird"));

        vehicleList.add(Vehicle1);
        vehicleList.add(Vehicle2);
        vehicleList.add(Vehicle3);

        int i;

        for (i = 0; i < vehicleList.size(); i++){
        System.out.println("The Model of Vehicle " + (i+1) +" is " + vehicleList.get(i).getVehicleModels());
            System.out.println("The Make of Vehicle " + (i+1) +" is " + vehicleList.get(i).getVehicleMakes());
            System.out.println("The color of Vehicle " + (i+1) +" is " + vehicleList.get(i).getColor());
        }

    }

    private static void LessonComplexProperties() {
        //notes: when to use inheritance (should answer the question "is a")
        //      when complex (nested) objects (should answer the question "has a"

        EntityType emailWorkType = new EntityType("Work");
        emailWorkType.setEntityTypeId(1);

        Email myEmail = new Email("bipin@bip.com");
        myEmail.setEmailType(emailWorkType);

        System.out.println((myEmail.getEmailAddress() + " Type:" + myEmail.getEmailType().getEntityTypeName()));

        //notes: collection/ list of complex nested objects as a property

        Employee myEmployee = new Employee();
        myEmployee.getEmails().add(new Email("test@test.com"));
        myEmployee.getEmails().add(new Email("dan@test.com"));
        myEmployee.getEmails().add(new Email("jason@test.com"));

        for (Email email : myEmployee.getEmails()) {
            System.out.println((email.getEmailAddress()));
        }
    }

    private static void LessonCollections() {
        //notes:    List<T> - generic type 'T'
        List<Employee> employeeList = new ArrayList<Employee>();

        Employee emp1 = new Employee("Dan", "Simmer");
        Employee emp2 = new Employee("James", "McRoberts");
        Employee emp3 = new Employee("Sean", "Nilsen");
        Employee emp4 = new Employee("Adrian", "Ratanyake");

        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        employeeList.add(emp4);

        employeeList.add(new Employee("John", "Doe"));

        for (Employee e : employeeList) {
            System.out.println(e.GetFullName());
        }

        System.out.println(employeeList.get(4).GetFullName());
    }

    private static void LessonObjectsLAB() {
        Address newAddress = new Address("1234", "pleasant ave");
        System.out.println(newAddress);

        Client newClient = new Client("BOA");
        System.out.println(newClient);

        Email newEmail = new Email("bob@bob.com");
        System.out.println(newEmail);

        Phone newPhone = new Phone(8590429);
        System.out.println(newPhone);

//        Vehicle newVehicle = new Vehicle("BOA213");
//        System.out.println(newVehicle);
    }

    private static void LessonMethods() {
        //notes:    method signature/declaration
        /*
            <access modifier>   <instance/static>   <return data type>  <method name> (<data type> <param name>, <data type> <param name>, ... {body}
               private          static              void                LessonMethods (nothing passed in)

               public           int                 getPersonId         (nothing passed in)

               public           void                setPersonId         (int personId)
         */

        //:notes constructors are special methods with same name as class
        Employee constructorEmployee = new Employee("Bipin", "Butala");
        System.out.println((constructorEmployee.getFirstName() + " " + constructorEmployee.getLastName()));

        Employee const2Employee = new Employee("Simmer");
        System.out.println(const2Employee.getLastName());

        Employee employeeJames = new Employee("James", "McRoberts");
        System.out.println(employeeJames.GetFullName());
    }

    private static void LessonInheritance() {
        //notes: 4 principles (tenets) Encapsulation, Abstraction, Inheritance, Polymorphism

        Employee employeeBip = new Employee();
        employeeBip.setFirstName("Bipin");
        employeeBip.setLastName("Butala");
        employeeBip.setId(3);


        System.out.println(employeeBip.getId() + ": " + employeeBip.getFirstName() + " " + employeeBip.getLastName());

        Person PersonBip = new Person();
        PersonBip.setFirstName("Bipin");
        PersonBip.setLastName("Butala");
        PersonBip.setId(2);


        System.out.println(PersonBip.getId() + ": " + PersonBip.getFirstName() + " " + PersonBip.getLastName());

    }

    private static void LessonClassObjects() {
        //notes: instantiating a new object
        Person myFirstPerson = new Person();
        myFirstPerson.setFirstName("Bipin");
        myFirstPerson.setLastName("Butala");
        myFirstPerson.setTitle("Mr.");

        System.out.print(myFirstPerson.getTitle());
        System.out.print(" ");
        System.out.print(myFirstPerson.getFirstName());
        System.out.print(" ");
        System.out.println(myFirstPerson.getLastName());

        Person mySecondPerson = new Person();
        mySecondPerson.setFirstName("Sarah");
        mySecondPerson.setLastName("Butala");
        mySecondPerson.setTitle("Mrs.");

        System.out.print(mySecondPerson.getTitle());
        System.out.print(" ");
        System.out.print(mySecondPerson.getFirstName());
        System.out.print(" ");
        System.out.println(mySecondPerson.getLastName());

        //notes: setting value for super (inherited class)
        myFirstPerson.setId(3);
        System.out.print(myFirstPerson.getId());
    }


    //    OOP Principles - LAB 1
//
//            1.     Create a separate method (LessonFizzBuzzLAB)
    private static void LessonFizzBuzzLAB() {
//
//2.     Write a loop that counts from 0-100
//
//    a.     If the value is divisible by 3 print "Fizz"
//
//    b.     If the value is divisible by 5 print "Buzz"
//
//    c.      If the value is divisible by 15 print "FizzBuzz"
//
//    d.     If the value is not divisible by 3,5, or 15 simply print the number
        for (int i = 0; i <= 100; i++) {
            if ((i % 15) == 0) {
                System.out.println("FizzBuzz");
            } else if ((i % 5) == 0) {
                System.out.println(("Buzz"));
            } else if ((i % 3) == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }

    //
//3.     Create another seperate method (LessonCalculatorLAB)
    private static void LessonCalculatorLAB() {

//
//            4.     Write code that prompts the user to enter a number from 0-9 and then reads the users input.
        Scanner reader = new Scanner(System.in);

        //notes: prompt the user
        System.out.print("Enter a value between 0-9: ");
        //notes: read input from the user and store the variable
        Integer input = reader.nextInt();
//
//            5.     If the user enters anything other than a number from 0-9, print "INVALID" to the console and reprommpt.
//
//6.     Prompt the user for a second number, with the same check.
        if (input < 0 || input > 9) {
            System.out.println("INVALID");
        }

        //notes: prompt the user
        System.out.print("Enter a value between 0-9: ");
        //notes: read input from the user and store the variable
        Integer input2 = reader.nextInt();

        if (input2 < 0 || input2 > 9) {
            System.out.println("INVALID");
        }
//
//            7.     Prompt the user to choose an operator (+, -, /, *) and accept input.
        Scanner operatorReader = new Scanner(System.in);

        System.out.print("choose an operator (+, -, /, *): ");
        String operatorInput = operatorReader.nextLine();
//
//            8.     If the user enters anything other than one of the four operators, print "INVALID" to the console and reprompt.

        if (!operatorInput.equals("+") && !operatorInput.equals("+") && !operatorInput.equals("+") && !operatorInput.equals("+")) {
            System.out.println("INVALID operator");
            System.out.print("choose an operator (+, -, /, *): ");
            operatorInput = operatorReader.nextLine();
        }
//9.     Using a switch/case perform the selected operation on the two entered numbers and output the result to the console
//
//            10.  Review and refactor your code to minimize the repeating of code, create additional methods if needed.
//
//11.  Write code that will throw an exception (other than the ones we covered in the lesson) and catch it.
        try {
            switch (operatorInput) {
                case "+":
                    System.out.println(input + input2);
                    break;
                case "-":
                    System.out.println(input - input2);
                    break;
                case "/":
                    System.out.println(input / input2);
                    break;
                case "*":
                    System.out.println(input * input2);
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }

    private static void LessonExceptions() throws Exception {
        // unhandled exception
        String firstName = "Bipin";
/*        int x = Integer.parseInt((firstName));
        System.out.print("Integer value: ");
        System.out.println(x);
        */
        // try catch block
        try {
            int x = Integer.parseInt((firstName));
            System.out.print("Integer value: ");
            System.out.println(x);
        }
//        catch (IllegalArgumentException ex){
//            System.out.println("Exception: String was null or empty " + ex.toString());
//        }
//        catch (NullPointerException ex) {
//            System.out.println("Exception: Null Pointer " + ex.toString());
//        }
//        catch (Exception ex) {
//            System.out.println("Exception: Generic Exception " + ex.toString());
//        }
        //custom exception
        catch (Exception ex) {
            throw new Exception("A Custom exception from LessonException method", ex);
        }
//        finally {
//            System.out.println("Program has been completed regardless of exceptions.");
//        }
    }

    private static void LessonFlowControl() {
        // if else

        // switch statement
        String name = "bip";
        switch (name) {
            case "bipin":
                System.out.println("cool first name");
                break;
            case "dan":
                break;
            case "danny":
                break;
            case "daniel":
                break;
            default:
                System.out.println("some other first name");
                break;
        }
    }

    private static void LessonOperators() {
        int val = 10;
        System.out.println(val + 10);
        System.out.println(val - 10);

        //modulus (%) the remainder
        int modVal = 10 % 3; // the remainder of 10 / 3 which is 1
        System.out.println(modVal);

        // increment ++ and decrement --
        System.out.println("increment after: ");
        System.out.println(val++); // 10
        System.out.println(val++); // 11
        System.out.println(val); // 12

        val = 10;
        System.out.println("increment before: ");
        System.out.println(++val); //11

        //logical operators (==) logical not equal !=

        //logical and (&&) / logical OR (||)


    }

    //1. Create a new private static method called LessonFundamentalsLAB().
    private static void LessonFundamentalsLAB() {

        // 2.What is a variable? Write code that prompts the user to enter a value from 1-10,
        // adds 1.75 to the number then outputs it to the console.
        //Variables are containers for storing data values.

        Scanner reader = new Scanner(System.in);

        //notes: prompt the user
        System.out.print("Enter a value between 1-10: ");
        //notes: read input from the user and store the variable
        Integer input = reader.nextInt();
        //notes: print the value back to the screen plus 1.75
        if (input >= 1 || input <= 10) {
            System.out.println(1.75 + input);
        } else {
            System.out.println("Invalid Value");
        }

        //3.Research the eight data types in Java,
        // create variables for these, and output the default,
        // max, and min values (where applicable).

        //byte
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println("The min and Max values for Byte are " + minByte + " and " + maxByte);
        //short
        short minShort = Short.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        System.out.println("The min and Max values for Short are " + minShort + " and " + maxShort);
        //int
        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.println("The min and Max values for Integer are " + minInt + " and " + maxInt);
        //long
        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;
        System.out.println("The min and Max values for Long are " + minLong + " and " + maxLong);
        //float
        float minFloat = Float.MIN_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.println("The min and Max values for Float are " + minFloat + " and " + maxFloat);
        //double
        double minDouble = Double.MIN_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println("The min and Max values for Double are " + minDouble + " and " + maxDouble);
        //boolean
        boolean minBoolean = false;
        boolean maxBoolean = true;
        System.out.println("The min and Max values for Boolean are " + minBoolean + " and " + maxBoolean);
        //char
        char minChar = Character.MIN_VALUE;
        char maxChar = Character.MAX_VALUE;
        System.out.println("The min and Max values for Character are " + minChar + " (or 0)" + " and " + maxChar + " (or 65,535");

        //4.Strings are not part of the eight primitive data types, why not?
        // which of the data types is a String actually composed of?
        // Prove this in your code.

        //-a String is an Array of Characters
        // Also String is non-primitive because only class can have methods.
        // Primitives cannot And Strings need many functions to be called upon
        // while processing like substring, indexof, equals, touppercase.
        // It would not have been possible without making it class

        String labString = "Example";

        for (int x = 0; x <= (labString.length() - 1); x++) {
            System.out.println("The index in the string which is an array is " + x + "At this Character " + labString.charAt(x));
        }

        //5.Create a List, populate it with values and then iterate thru those values
        // outputting them to the console.
        // Why can you not create a List of 'char' or 'int'?

        //You cannot use primitive types as a generic type-parameter;
        // you need to use the wrapper class for char, which is Character:
        //This goes for any class that accepts a generic type-parameter.
        // So for example, if you had tried to use int , instead, you would have had to use Integer.
        List<Integer> myLabList = new ArrayList<Integer>();

        myLabList.add(1);
        myLabList.add(2);
        myLabList.add(3);
        myLabList.add(4);
        myLabList.add(5);

        System.out.println(myLabList);

        for (Integer singleItem : myLabList) {
            System.out.println(singleItem);
        }

        //6.Create variables of appropriate data types,
        // to store information regarding a lottery ticket
        // (i.e. GameName, WinningNumbers, Jackpot, DrawingDate, etc..).
        // Populate these variables and output them to the console.

        String GameName = "MegaMillions";
        List<Integer> winningNumbers = new ArrayList<Integer>();
        winningNumbers.add(1);
        winningNumbers.add(52);
        winningNumbers.add(71);
        winningNumbers.add(87);
        winningNumbers.add(92);
        winningNumbers.add(32);

        int jackpot = 10000000;

        Date DrawingDate = new Date();


        byte price = 100;

        String odds = "1 in 10";

        System.out.println(GameName + " costs " + price + " per ticket and the odds are " + odds + " for a jackpot of " +
                jackpot + " which was drawn on " + DrawingDate + " with the winning numbers " + winningNumbers);


    }

    private static void LessonLists() {
        //notes: collections/Lists
        List<String> myStringCollection = new ArrayList<String>();

        myStringCollection.add("1st String");
        myStringCollection.add("2nd String");
        myStringCollection.add("3rd String");
        myStringCollection.add("4th String");
        myStringCollection.add("5th String");

        System.out.println(myStringCollection);

        for (String singleString : myStringCollection) {
            System.out.println(singleString);
        }

        List<Integer> myIntCollection = new ArrayList<Integer>();

        myIntCollection.add(10);
        myIntCollection.add(20);
        myIntCollection.add(30);
        myIntCollection.add(40);
        myIntCollection.add(50);

        System.out.println(myIntCollection);

        for (int singleInt : myIntCollection) {
            System.out.println(singleInt);
        }

        String[] myStringArray = new String[6];

        myStringArray[0] = "1st";
        myStringArray[1] = "2nd";
        myStringArray[2] = "3rd";
        myStringArray[3] = "4th";
        myStringArray[4] = "5th";

        System.out.println(myStringArray);

        for (String singleString : myStringArray) {
            System.out.println(singleString);
        }

        myStringArray[5] = "6th";

        Integer[] myIntArray = new Integer[5];

        myIntArray[0] = 1;
        myIntArray[1] = 2;
        myIntArray[2] = 3;
        myIntArray[3] = 4;
        myIntArray[4] = 5;

        System.out.println(myIntArray);

        for (Integer singleInt : myIntArray) {
            System.out.println(singleInt);
        }

    }

    private static void LessonStrings() {
        String firstString = "";
        //firstString = "something";
        firstString = null;

        if (firstString == null || firstString.isEmpty()) {
            System.out.println("String is empty");
        } else {
            System.out.println("String has a value");
        }

        //notes: immutable - unable to be changed....
        firstString = "another value"; //this creates a new string

        for (int x = 0; x <= 100; x++) {
            firstString = "new value" + Integer.toString(x);
            System.out.println(firstString); // we are creating a new string for every iteration 100 strings
            //very inefficient!!
        }

        //notes: StringBuilder()
        StringBuilder myStringBuilder = new StringBuilder();

        for (int x = 0; x <= 100; x++) {
            myStringBuilder.append("new value with string builder");
            myStringBuilder.append(Integer.toString(x));
            myStringBuilder.append("\n");
        }

        System.out.println(myStringBuilder);

        //searching through strings indexof lastindexof
        String myName = "Bipin";

        int indexof = myName.indexOf("i");
        System.out.println(indexof);

        String largeString = "This is a longer string than before";
        for (char c : largeString.toCharArray()) {
            System.out.println(c);
        }

        //substring
        String partOfLargerString = largeString.substring(8, 16);
        System.out.println(partOfLargerString);
    }

    private static void LessonDataTypes() {
        //notes: primitive data types
        //      int(number)
        //      float   (floating point . decimal)
        //      double  (larger number)
        //      boolean (true or false)
        //      char (character)

        //notes: common data types
        boolean myBool = false;
        int myInt = 4;
        String myString = "some words";
        Date myDate = new Date();

        System.out.println(myBool);
        System.out.println(myInt);
        System.out.println(myString);
        System.out.println(myDate);

        //notes: parsing/ converting data types

        //notes: string -> int
        String numberString = "341";
        int intFromString = Integer.parseInt(numberString);

        System.out.println(intFromString);

        //notes: int -> string
        int i = 312;
        String stringFromInt = Integer.toString(i);
        System.out.println(stringFromInt);

        //notes: date -> string
        String stringFromDate = myDate.toString();
        System.out.println((stringFromDate));
    }

    private static void LessonVariables() {
        //notes: use variable declared outside of this scope


        //notes: declare variable and setting value of variable
        String lastName = "Butala", firstName = "Bipin";

        //notes: output to the console
        System.out.println(firstName + " " + lastName);

        //notes: create Scanner object
        Scanner reader = new Scanner(System.in);

        //notes: prompt the user
        System.out.print("Enter your name: ");
        //notes: read input from the user and store the variable
        String input = reader.nextLine();
        //notes: print the value back to the screen
        System.out.println("Hello " + input);
    }
}
