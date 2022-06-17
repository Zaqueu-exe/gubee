package com.alves.domain.dao.impl;

import com.alves.domain.dao.daoAbstract.TechnologyDao;
import com.alves.domain.entities.Technology;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnologyDaoJDBC implements TechnologyDao {
    private Connection conn = null;

    public TechnologyDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Technology technology) {
        String sql = "INSERT INTO technology " +
                "(name) " +
                "VALUES (?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            conn.setAutoCommit(false);

            pstm.setString(1, technology.getName());
            pstm.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new RuntimeException("Rolled back " + e.getMessage());
            } catch (SQLException e1) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    @Override
    public List<Technology> findAll() {
        String sql = "SELECT * FROM technology";

        List<Technology> technologies = new ArrayList<>();
        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            try (ResultSet rset = pstm.executeQuery()) {
                while (rset.next()) {
                    technologies.add(Technology.builder()
                            .id(rset.getLong("id"))
                            .name(rset.getString("name"))
                            .build());
                }
            } catch (SQLException e1) {
                throw new RuntimeException(e1.getMessage());
            }

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return technologies;
    }
}
