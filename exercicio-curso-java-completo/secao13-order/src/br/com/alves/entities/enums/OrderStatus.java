package br.com.alves.entities.enums;

public enum OrderStatus {
    PENDING_PAYMENT(0),
    PROCESSING(1),
    SHIPPED(2),
    DELIVERED(3);

    private int indice;
    OrderStatus(int i) {
        this.indice = i;
    }

    public int getIndice(){
        return this.indice;
    }
}
