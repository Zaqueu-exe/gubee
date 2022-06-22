package com.alves.domain.dao.impl;

import com.alves.domain.dao.daoAbstract.ProductDao;
import com.alves.domain.entities.Product;
import com.alves.domain.entities.Technology;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDaoJDBC implements ProductDao {

    private Connection conn = null;

    public ProductDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Product product) {
        String sql = "INSERT INTO product " +
                "(name, description, targetmarket) " +
                "VALUES (?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            pstm.setString(1, product.getName());
            pstm.setString(2, product.getDescription());
            pstm.setString(3, product.getTargetMarket());
            pstm.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new RuntimeException("Rolled back " + e.getMessage());
            } catch (SQLException e1) {
                throw new RuntimeException(e1.getMessage());
            }
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";

        List<Product> list = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    Product product = this.instantiationProduct(rset);
                    product.setTechnologies(this.productUseTechnology(product.getId()));
                    list.add(product);
                }
                return list;
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1.getMessage());
        }
    }

    @Override
    public void insertTechnologyInProduct(Product product, Technology technology) {
        String sql = "INSERT INTO productusetechnology " +
                "(product_id, technology_id) " +
                "VALUES " +
                "(?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setLong(1, product.getId());
            pstm.setLong(2, technology.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Product> findByTechnology(String technologyName) {
        String sql = "SELECT * FROM product " +
                "INNER JOIN productusetechnology " +
                "ON product.id = product_id " +
                "INNER JOIN technology " +
                "ON technology.id = technology_id " +
                "WHERE technology.name like ?";

        List<Product> products = new ArrayList<>();

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, technologyName);
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    Product product = instantiationProduct(rset);
                    product.setTechnologies(productUseTechnology(product.getId()));
                    products.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> findByTargetMarket(String targetMarket) {
        String sql = "SELECT * FROM product WHERE targetmarket like ?";

        List<Product> list = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, "%" + targetMarket + "%");
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    Product product = instantiationProduct(rset);
                    product.setTechnologies(productUseTechnology(product.getId()));
                    list.add(product);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1.getMessage());
        }
        return list;
    }

    private Product instantiationProduct(ResultSet rset) throws SQLException {
        Product product = Product.builder()
                .id(rset.getLong("id"))
                .name(rset.getString("name"))
                .description(rset.getString("description"))
                .targetMarket(rset.getString("targetmarket"))
                .build();

        return product;
    }

    private Technology instatiationTechnology(ResultSet rset) throws SQLException {
        Technology technology = Technology.builder()
                .id(rset.getLong("technology.id"))
                .name(rset.getString("technology.name"))
                .build();

        return technology;
    }

    private List<Technology> productUseTechnology(Long id) {
        String sql = "SELECT * FROM technology " +
                "INNER JOIN productusetechnology " +
                "ON technology.id = technology_id " +
                "WHERE productusetechnology.product_id = ?";
        List<Technology> list = new ArrayList<>();

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setLong(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {

                    Technology technology = instatiationTechnology(rset);

                    list.add(technology);
                }
            } catch (SQLException e1) {
                throw new RuntimeException(e1.getMessage());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return list;
    }
}


