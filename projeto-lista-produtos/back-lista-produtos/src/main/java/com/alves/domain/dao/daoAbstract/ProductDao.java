package com.alves.domain.dao.daoAbstract;

import com.alves.domain.entities.Product;
import com.alves.domain.entities.Technology;
import java.util.List;

public interface ProductDao {

    void insert(Product product);
    List<Product> findAll();
    void insertTechnologyInProduct(Product product, Technology technology);
    List<Product> findByTechnology(String technologyName);
    List<Product> findByTargetMarket(String targetMarket);

}
