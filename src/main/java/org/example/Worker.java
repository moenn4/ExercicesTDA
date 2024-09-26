package org.example;

public class Worker {
    private WorkerType type;
    private double hourlyWage;
    private double workedHours;
    private double annualSalary;
    public Salary getSallary(){
        if (type == WorkerType.HOURLY) {
            return new Salary(hourlyWage * workedHours);
        } else {
            return new Salary(annualSalary / 52.0);
        }
    }
}
