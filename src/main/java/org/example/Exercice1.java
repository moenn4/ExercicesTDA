package org.example;

import java.util.LinkedList;
import java.util.List;

public class Exercice1 {

    public List<Salary> getAllWorkerSalaries(List<Worker> workers) {
        List<Salary> salaries = new LinkedList<>();
        for (Worker worker : workers) {
            salaries.add(worker.getSallary());
        }

        return salaries;
    }
}


