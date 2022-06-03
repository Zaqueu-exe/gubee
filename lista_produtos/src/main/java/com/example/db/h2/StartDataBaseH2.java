package com.example.db.h2;

import com.example.domain.MakeDao;
import com.example.domain.dao.daoAbstract.ProductDao;
import com.example.domain.dao.daoAbstract.TechnologyDao;
import com.example.domain.entities.Product;
import com.example.domain.entities.Technology;

import java.sql.SQLException;

public class StartDataBaseH2 {

    private final ProductDao productDao = MakeDao.createDaoJDBC().getProductDao();
    private final TechnologyDao technologyDao = MakeDao.createDaoJDBC().getTechnologyDao();

    public void initDataBase() throws SQLException {
        H2.createTables();
        this.insertTechnologies();
        this.insertProducts();
        this.insertTechnologyInProduct();
    }

    private void insertProducts() {
        productDao.insert(Product.builder()
                .name("Yahoo")
                .description("site de entreterimento")
                .targetMarket("Publico geral")
                .build());
        productDao.insert(Product.builder()
                .name("G1")
                .description("Site de noticias e variedades")
                .targetMarket("Publico geral")
                .build());
        productDao.insert(Product.builder()
                .name("R7")
                .description("Site de noticias")
                .targetMarket("Publico geral")
                .build());
        productDao.insert(Product.builder()
                .name("Google Chrome")
                .description("Buscador")
                .targetMarket("Publico geral")
                .build());
        productDao.insert(Product.builder()
                .name("Visual Studio")
                .description("Programa para desenvolvimento")
                .targetMarket("Programadores")
                .build());
    }

    private void insertTechnologies() {
        technologyDao.insert(Technology.builder()
                .name("HTML")
                .build());
        technologyDao.insert(Technology.builder()
                .name("SQL")
                .build());
        technologyDao.insert(Technology.builder()
                .name("JavaScript")
                .build());
        technologyDao.insert(Technology.builder()
                .name("Java")
                .build());
        technologyDao.insert(Technology.builder()
                .name("CSS")
                .build());
        technologyDao.insert(Technology.builder()
                .name("XML")
                .build());
    }

    private void insertTechnologyInProduct() {
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(1L)
                        .build()
                , Technology.builder()
                        .id(1L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(1L)
                        .build()
                , Technology.builder()
                        .id(2L)
                        .build());

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(2L)
                        .build()
                , Technology.builder()
                        .id(3L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(2L)
                        .build()
                , Technology.builder()
                        .id(5L)
                        .build());

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(3L)
                        .build()
                , Technology.builder()
                        .id(4L)
                        .build());

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(4L)
                        .build()
                , Technology.builder()
                        .id(1L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(4L)
                        .build()
                , Technology.builder()
                        .id(2L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(4L)
                        .build()
                , Technology.builder()
                        .id(3L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(4L)
                        .build()
                , Technology.builder()
                        .id(5L)
                        .build());
    }
}
