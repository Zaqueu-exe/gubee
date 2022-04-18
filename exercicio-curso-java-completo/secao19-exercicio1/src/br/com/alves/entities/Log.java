package br.com.alves.entities;

import java.util.Date;
import java.util.Objects;

public class Log {
    private String name;
    private Date data;

    public Log(String name, Date data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public Date getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(name, log.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
