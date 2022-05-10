package model.dao.impl;

import db.DB;
import model.anotation.Transaction;
import model.dao.PessoaDao;
import model.entities.Pessoa;

import java.sql.*;
import java.util.HashSet;


public class PessoaDaoJDBC implements PessoaDao {

    private Connection conn;

    public PessoaDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Transaction
    @Override
    public void insert(Pessoa pessoa) {
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
    public Pessoa findById(Long id) {
        String sql = "SELECT * FROM pessoa WHERE id = ?";

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setLong(1, id);
            try (ResultSet rset = pstm.executeQuery()) {
                if (rset.next()) {
                    Pessoa pessoa = instatiationPessoa(rset);
                    return pessoa;
                }
            } catch (SQLException e) {
                e.getMessage();
            }
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            DB.closeStatment(pstm);
        }
        return null;
    }

    @Transaction
    @Override
    public HashSet<Pessoa> findAll() {
        String sql = "SELECT * FROM pessoa";
        HashSet<Pessoa> hashSet = new HashSet<>();

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    hashSet.add(instatiationPessoa(rset));
                }
                return hashSet;
            } catch (SQLException e) {
                e.getMessage();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return null;
    }

    private Pessoa instatiationPessoa(ResultSet rset) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(rset.getLong("id"));
        pessoa.setNome(rset.getString("nome"));
        pessoa.setDataNascimento(rset.getDate("dataNascimento"));
        return pessoa;
    }
}
