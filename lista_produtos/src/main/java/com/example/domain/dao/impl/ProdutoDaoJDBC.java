package com.example.domain.dao.impl;

import com.example.domain.dao.daoAbstract.ProdutoDao;
import com.example.domain.entities.Produto;
import com.example.domain.entities.Tecnologia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProdutoDaoJDBC implements ProdutoDao {

    private Connection conn = null;

    public ProdutoDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto " +
                "(nome, descricao, mercadoalvo) " +
                "VALUES (?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setString(3, produto.getMercadoAlvo());
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
    public void inserirTecnologiaAoProduto(Produto produto, Tecnologia tecnologia) {
        String sql = "INSERT INTO produtousetecnologia " +
                "(produto_id, tecnologia_id) " +
                "VALUES " +
                "(?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setLong(1, produto.getId());
            pstm.setLong(2, tecnologia.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Produto> findAll() {
        String sql = "SELECT * FROM produto";

        List<Produto> produtos = new ArrayList<>();
        // Map<Long, >

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    Produto produto = instantiationProduto(rset);
                    produto.addAllTecnologia(produtoUsaTecnologia(produto.getId()));
                    produtos.add(produto);
                }
            } catch (SQLException e1) {
                throw new RuntimeException(e1.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return produtos;
    }

    @Override
    public Produto findById(Produto produto) {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setLong(1, produto.getId());
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    produto.setNome(rset.getString("nome"));
                    produto.setDescricao(rset.getString("descricao"));
                    produto.setMercadoAlvo(rset.getString("mercadoalvo"));
                    produto.addAllTecnologia(produtoUsaTecnologia(produto.getId()));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1.getMessage());
        }
        return produto;
    }

    @Override
    public Set<Produto> findBytecnologia(Tecnologia... tecnologias) {
        String sql = "SELECT * FROM produto " +
                "INNER JOIN produtousetecnologia " +
                "ON produto.id = produto_id " +
                "INNER JOIN tecnologia " +
                "ON tecnologia.id = tecnologia_id " +
                "WHERE tecnologia.nome like ?";

        Set<Produto> produtos = new HashSet<>();

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, tecnologias[0].getNome());
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    Produto p = instantiationProduto(rset);
                    p.addAllTecnologia(produtoUsaTecnologia(p.getId()));
                    produtos.add(p);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1.getMessage());
        }
        return produtos;
    }

    @Override
    public List<Produto> findByMercadoAlvo(String mercadoAlvo) {
        String sql = "SELECT * FROM produto WHERE mercadoalvo like ?";

        List<Produto> list = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, mercadoAlvo);
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    Produto p = instantiationProduto(rset);
                    p.addAllTecnologia(produtoUsaTecnologia(p.getId()));
                    list.add(p);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e1) {
            throw new RuntimeException(e1.getMessage());
        }
        return list;
    }

    private Produto instantiationProduto(ResultSet rset) throws SQLException {
        Produto produto = new Produto(rset.getLong("id"),
                rset.getString("nome"),
                rset.getString("descricao"),
                rset.getString("mercadoalvo"));

        return produto;
    }

    private Tecnologia instatiationTecnologia(ResultSet rset) throws SQLException {
        Tecnologia tecnologia = new Tecnologia(rset.getLong("tecnologia.id"),
                rset.getString("tecnologia.nome"));

        return tecnologia;
    }

    // Saber todas as tecnologias de um produto pelo id dele
    private List<Tecnologia> produtoUsaTecnologia(Long id) {
        String sql = "SELECT * FROM tecnologia " +
                "INNER JOIN produtousetecnologia " +
                "ON tecnologia.id = tecnologia_id " +
                "WHERE produtousetecnologia.produto_id = ?";
        List<Tecnologia> list = new ArrayList<>();

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setLong(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {

                    Tecnologia tecnologia = instatiationTecnologia(rset);

                    list.add(tecnologia);
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
