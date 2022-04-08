package br.com.alves.entities.enums;

public enum WorkerLevel {
    JUNIO(1),
    MID_LEVEL(2),
    SENIOR(3);

    private  int indice;

    WorkerLevel(int indice){
        this.indice = indice;
    }

    public int getIndice(){
        return this.indice;
    }

}
