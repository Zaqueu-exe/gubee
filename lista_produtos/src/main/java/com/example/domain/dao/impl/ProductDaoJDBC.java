package com.example.domain.dao.impl;

import com.example.domain.dao.daoAbstract.ProductDao;
import com.example.domain.entities.Product;
import com.example.domain.entities.Technology;

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
        String sql = "INSERT INTO produto " +
                "(nome, descricao, mercadoalvo) " +
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
    public void insertTechnologyInProduct(Product product, Technology technology) {
        String sql = "INSERT INTO produtousetecnologia " +
                "(produto_id, tecnologia_id) " +
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
        String sql = "SELECT * FROM produto " +
                "INNER JOIN produtousetecnologia " +
                "ON produto.id = produto_id " +
                "INNER JOIN tecnologia " +
                "ON tecnologia.id = tecnologia_id " +
                "WHERE tecnologia.nome like ?";

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
        String sql = "SELECT * FROM produto WHERE mercadoalvo like ?";

        List<Product> list = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, targetMarket);
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
                .name(rset.getString("nome"))
                .description(rset.getString("descricao"))
                .targetMarket(rset.getString("mercadoalvo"))
                .build();

        return product;
    }

    private Technology instatiationTechnology(ResultSet rset) throws SQLException {
        Technology technology = Technology.builder()
                .id(rset.getLong("tecnologia.id"))
                .name(rset.getString("tecnologia.nome"))
                .build();

        return technology;
    }

    // Saber todas as tecnologias de um produto pelo id dele
    private List<Technology> productUseTechnology(Long id) {
        String sql = "SELECT * FROM tecnologia " +
                "INNER JOIN produtousetecnologia " +
                "ON tecnologia.id = tecnologia_id " +
                "WHERE produtousetecnologia.produto_id = ?";
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


