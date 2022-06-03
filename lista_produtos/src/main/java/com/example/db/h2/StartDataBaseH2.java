package com.example.db.h2;

import com.example.domain.MakeDao;
import com.example.domain.dao.daoAbstract.ProductDao;
import com.example.domain.dao.daoAbstract.TechnologyDao;
import com.example.domain.entities.Product;
import com.example.domain.entities.Technology;

import java.sql.SQLException;

public class StartDataBaseH2 {

    private ProductDao productDao = MakeDao.createDaoJDBC().getProductDao();
    private TechnologyDao technologyDao = MakeDao.createDaoJDBC().getTechnologyDao();

    public void initDataBase() throws SQLException {
        H2.createTables();
        this.insertTechnologies();
        this.insertProducts();
        this.insertTechnologyInProduct();
    }

    private void insertProducts(){
        productDao.insert(new Product(null, "Yahoo", "site de entreterimento", "Publico geral"));
        productDao.insert(new Product(null, "G1", "", "Publico geral"));
        productDao.insert(new Product(null, "R7", "Site de noticias", "Publico geral"));
        productDao.insert(new Product(null, "Google chrome", "Buscador", "Publico geral"));
        productDao.insert(new Product(null, "Visual Studio", "Programa para desenvolvimento", "Programadores"));
    }
    private void insertTechnologies(){
        technologyDao.insert(new Technology(null, "HTML"));
        technologyDao.insert(new Technology(null, "SQL"));
        technologyDao.insert(new Technology(null, "JavaScript"));
        technologyDao.insert(new Technology(null, "Java"));
        technologyDao.insert(new Technology(null, "CSS"));
        technologyDao.insert(new Technology(null, "XML"));
    }
    private void insertTechnologyInProduct(){
        productDao.insertTechnologyInProduct(new Product(1L), new Technology(1L));
        productDao.insertTechnologyInProduct(new Product(1L), new Technology(2L));

        productDao.insertTechnologyInProduct(new Product(2L), new Technology(3L));
        productDao.insertTechnologyInProduct(new Product(2L), new Technology(5L));

        productDao.insertTechnologyInProduct(new Product(3L), new Technology(4L));

        productDao.insertTechnologyInProduct(new Product(4L), new Technology(1L));
        productDao.insertTechnologyInProduct(new Product(4L), new Technology(2L));
        productDao.insertTechnologyInProduct(new Product(4L), new Technology(3L));
        productDao.insertTechnologyInProduct(new Product(4L), new Technology(5L));
    }
}
