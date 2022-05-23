package com.example.domain.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto implements Serializable {
    private Long id;
    private String nome;
    private String descricao;
    private String mercadoAlvo;
    private List<Tecnologia> tecnologias = new ArrayList<>();

    public Produto(){

    }
    public Produto(Long id, String nome, String descricao, String mercadoAlvo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.mercadoAlvo = mercadoAlvo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descrica) {
        this.descricao = descrica;
    }

    public String getMercadoAlvo() {
        return mercadoAlvo;
    }

    public void setMercadoAlvo(String mercadoAlvo) {
        this.mercadoAlvo = mercadoAlvo;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void addTecnologia(Tecnologia tecnologia) {
        this.tecnologias.add(tecnologia);
    }

    public void addAllTecnologia(List<Tecnologia> tecnologias) {
        this.tecnologias.addAll(tecnologias);
    }
    public void removeTecnologia(Tecnologia tecnologia) {
        this.tecnologias.remove(tecnologia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descrica='" + descricao + '\'' +
                ", mercado alvo='" + mercadoAlvo + '\'' +
                ", tecnologias=" + tecnologias +
                '}';
    }
}
