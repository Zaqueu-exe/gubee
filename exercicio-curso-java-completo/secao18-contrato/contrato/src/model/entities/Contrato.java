package model.entities;

import model.services.ServicePayment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Contrato {
    private int numero;
    private double valorContrato;

    private Date date;
    List<Parcela> parcelas = new ArrayList<>();

    public Contrato(int numero, double valorContrato, Date date) {
        this.numero = numero;
        this.valorContrato = valorContrato;
        this.date = date;
    }

    public Date dataParcela(Date date, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, mes);
        return cal.getTime();
    }

    public List<Parcela> getParcelas() {
        return parcelas;
    }

    public void addParcelas(Parcela parcela) {
        this.parcelas.add(parcela);
    }

    public int getNumero() {
        return numero;
    }

    public double getValorContrato() {
        return valorContrato;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Parcela p: getParcelas()){
            sb.append(p + "\n");
        }
        return sb.toString();
    }
}
