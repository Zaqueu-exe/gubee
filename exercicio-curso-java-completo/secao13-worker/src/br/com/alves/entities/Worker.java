package br.com.alves.entities;

import br.com.alves.entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public Worker() {

    }

    public void addContract(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContract(HourContract contract) {
        contracts.remove(contract);
    }

    public double income(Integer year, Integer month) {
        Double total = 0.0;
        Calendar cal = Calendar.getInstance();
        for (HourContract aux : contracts) {
            cal.setTime(aux.getDate());
            int monthIn = cal.get(Calendar.MONTH);
            int yearIn = cal.get(Calendar.YEAR);
            if (year == yearIn && (month - 1) == monthIn) {
                total += aux.totalValue();
            }
        }
        return total + baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Department: " + department;
    }
}
