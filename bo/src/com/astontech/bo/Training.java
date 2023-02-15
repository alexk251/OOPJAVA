package com.astontech.bo;

import java.util.Date;

public class Training extends Employee {
    private int TrainingId;
    private int EmployeeId;
    private String TrainingName;
    private Date DateCreate;

    public Training() {}

    public Training(String trainingName) {
        this.setTrainingName(trainingName);
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    @Override
    public int getEmployeeId() {
        return EmployeeId;
    }

    @Override
    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }
}
