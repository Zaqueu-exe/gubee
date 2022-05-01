package com.alves.pedido.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Pedido implements Serializable {

    @Id
    private String id;
    private Double precoTotal;
    private List<PedidoItem> pedidoItemList = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(String id, List<PedidoItem> pedidoItemList) {
        this.id = id;
        this.pedidoItemList = pedidoItemList;
        this.precoTotal = 0.0;
        for(PedidoItem pi : this.pedidoItemList){
            this.precoTotal += pi.getSubTotal();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public List<PedidoItem> getPedidoItemList() {
        return pedidoItemList;
    }

    public void setPedidoItemList(List<PedidoItem> pedidoItemList) {
        this.pedidoItemList = pedidoItemList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
