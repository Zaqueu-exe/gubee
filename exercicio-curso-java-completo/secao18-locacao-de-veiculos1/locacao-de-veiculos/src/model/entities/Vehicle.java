package model.entities;

public class Vehicle {
    private String modelo;

    public Vehicle(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return modelo;
    }
}
