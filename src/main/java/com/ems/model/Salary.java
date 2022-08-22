package com.ems.model;

public class Salary {
    private int employeeId;
    private double amount;

    public Salary() {

    }

    @Override
    public String toString() {
        return "Salary{" +
                "employeeId=" + employeeId +
                ", amount=" + amount +
                '}';
    }

    public Salary(int employeeId, double amount) {
        this.employeeId = employeeId;
        this.amount = amount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
