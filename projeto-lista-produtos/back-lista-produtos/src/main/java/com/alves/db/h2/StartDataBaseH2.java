package com.alves.db.h2;

import com.alves.domain.MakeDao;
import com.alves.domain.dao.daoAbstract.ProductDao;
import com.alves.domain.dao.daoAbstract.TechnologyDao;
import com.alves.domain.entities.Product;
import com.alves.domain.entities.Technology;

import java.sql.SQLException;

public class StartDataBaseH2 {

    private final ProductDao productDao = MakeDao.createDaoJDBC().getProductDao();
    private final TechnologyDao technologyDao = MakeDao.createDaoJDBC().getTechnologyDao();

    public StartDataBaseH2(){
        try {
            this.initDataBase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
        productDao.insert(Product.builder()
                .name("JPTX")
                .description("Site de vendas")
                .targetMarket("Publico geral")
                .build());
        productDao.insert(Product.builder()
                .name("KHG")
                .description("API de monitoriamento climatico")
                .targetMarket("Programas de consultas")
                .build());
        productDao.insert(Product.builder()
                .name("DFR")
                .description("Site para calculo de imposto")
                .targetMarket("Pessoas que estão com os impostos atrasados")
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
        technologyDao.insert(Technology.builder()
                .name("JSON")
                .build());
        technologyDao.insert(Technology.builder()
                .name("Scala")
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

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(5L)
                        .build()
                , Technology.builder()
                        .id(6L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(5L)
                        .build()
                , Technology.builder()
                        .id(7L)
                        .build());

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(6L)
                        .build()
                , Technology.builder()
                        .id(6L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(6L)
                        .build()
                , Technology.builder()
                        .id(2L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(6L)
                        .build()
                , Technology.builder()
                        .id(4L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(6L)
                        .build()
                , Technology.builder()
                        .id(1L)
                        .build());

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(7L)
                        .build()
                , Technology.builder()
                        .id(2L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(7L)
                        .build()
                , Technology.builder()
                        .id(5L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(7L)
                        .build()
                , Technology.builder()
                        .id(8L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(7L)
                        .build()
                , Technology.builder()
                        .id(4L)
                        .build());
        productDao.insertTechnologyInProduct(Product.builder()
                        .id(7L)
                        .build()
                , Technology.builder()
                        .id(3L)
                        .build());

        productDao.insertTechnologyInProduct(Product.builder()
                        .id(8L)
                        .build()
                , Technology.builder()
                        .id(8L)
                        .build());
    }
}
