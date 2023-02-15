package com.astontech.bo;

public class Email extends BaseBO {
    private int EmailId;
    private String EmailAddress;
    private int EntityTypeId;
    private int EmployeeId;
    private EntityType EmailType;
    private Employee employee;


    public Email() {
        this.setEmailType(new EntityType());
    }

    public Email(String emailAddress) {
        this.setEmailType(new EntityType());
        this.setEmailAddress(emailAddress);
    }

    public int getEmailId() {
        return EmailId;
    }

    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public EntityType getEmailType() {
        return EmailType;
    }

    public void setEmailType(EntityType emailType) {
        EmailType = emailType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }
}
