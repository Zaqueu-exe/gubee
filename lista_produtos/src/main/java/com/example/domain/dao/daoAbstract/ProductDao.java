package com.example.domain.dao.daoAbstract;

import com.example.domain.entities.Product;
import com.example.domain.entities.Technology;
import java.util.List;

public interface ProductDao {

    void insert(Product product);

    void insertTechnologyInProduct(Product product, Technology technology);

    List<Product> findByTechnology(Technology... technologies);

    List<Product> findByTargetMarket(String targetMarket);

}
