package org.example;

public class Exercice1 {

    public List<Salary> getAllWorkerSalaries(List<Worker> workers) {
        List<Salary> salaries = new LinkedList<>();
        for (Worker worker : workers) {
            if (worker.getType() == WorkerType.HOURLY) {
                double hourlyWage = worker.getHourlyWage();
                double hours = worker.getWorkedHours();
                salaries.add(new Salary(hourlyWage * hours));
            } else {
                double salary = worker.getAnnualSalary() / 52.0;
                salaries.add(new Salary(salary));
            }
        }

        return salaries;
    }
}


