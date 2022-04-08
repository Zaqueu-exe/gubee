package br.com.alves.entities;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private Double salary;

    public Employee(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void increaseSalary(Double percentage){
        salary += salary * (percentage/100.0);
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + ": " + name + " " + String.format("%.2f", salary);
    }

}
