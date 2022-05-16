package com.alves.model.dao.impl;

import com.alves.model.anotation.Transaction;
import com.alves.db.DB;
import com.alves.model.dao.PessoaDao;
import com.alves.model.entities.Pessoa;
import com.alves.model.entities.abstractPessoa.PessoaAbstrata;

import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/* */
public class PessoaDaoJDBC implements PessoaDao {

    private Connection conn;

    public PessoaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Transaction
    @Override
    public void insert(PessoaAbstrata pessoa) {
        String sql = "INSERT INTO pessoa (nome, dataNascimento) VALUES (?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            pstm.setString(1, pessoa.getNome());
            pstm.setDate(2, new Date(pessoa.getDataNascimento().getTime()));
            pstm.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new RuntimeException("Rolled back"+ e.getMessage());
            } catch (SQLException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
    }

    @Override
    public PessoaAbstrata findById(Long id) {
        String sql = "SELECT * FROM pessoa WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    PessoaAbstrata pessoa = instatiationPessoa(rset);
                    return pessoa;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            DB.closeStatment(pstm);
        }
        return null;
    }

    @Transaction
    @Override
    public List<PessoaAbstrata> findAll() {
        String sql = "SELECT * FROM pessoa";
        List<PessoaAbstrata> list = new ArrayList<>();

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    list.add(instatiationPessoa(rset));
                }
                return list;
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private PessoaAbstrata instatiationPessoa(ResultSet rset) throws SQLException {
        PessoaAbstrata pessoa = new Pessoa();
        pessoa.setId(rset.getLong("id"));
        pessoa.setNome(rset.getString("nome"));
        pessoa.setDataNascimento(rset.getDate("dataNascimento"));
        return pessoa;
    }
}
