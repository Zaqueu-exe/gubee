package model.services;

import model.entities.Contrato;
import model.entities.Parcela;

import java.util.Calendar;
import java.util.Date;

public class ContratoService {
    private ServicePayment servicePayment;

    public ContratoService(ServicePayment servicePayment) {
        this.servicePayment = servicePayment;
    }

    public ServicePayment getServicePayment() {
        return servicePayment;
    }

    public void processaContrato(Contrato contrato, int meses) {
        double parcelaBasica = contrato.getValorContrato() / meses;

        for (int i = 1; i <= meses; i++) {
            Date data = calculaMes(contrato.getDate(), i);
            contrato.addParcelas(new Parcela(data, calculaValorParcela(parcelaBasica, i)));
        }
    }

    private Date calculaMes(Date date, int mes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, mes);
        return cal.getTime();
    }

    private Double calculaValorParcela(double amount, int mes) {
        double parcelaAtualizada = amount + servicePayment.valorParcela(mes, amount);
        double total = parcelaAtualizada + servicePayment.taxaPagamento(parcelaAtualizada);
        return total;
    }
}
