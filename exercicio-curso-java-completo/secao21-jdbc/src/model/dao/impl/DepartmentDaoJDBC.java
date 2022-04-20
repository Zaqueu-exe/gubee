package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department obj) {
        String sql = "INSERT INTO department " +
                "(Name) " +
                "VALUES (?)";
        try (PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, obj.getName());
            int rows = pstm.executeUpdate();

            if (rows > 0) {
                ResultSet rset = pstm.getGeneratedKeys();
                if (rset.next()) {
                    int id = rset.getInt(1);
                    obj.setId(id);

                }
                DB.closeResultSet(rset);
            } else {
                throw new DbException("Unexpected error!");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void update(Department obj) {
        String sql = "UPDATE department " +
                "SET name = ? " +
                "WHERE Id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, obj.getName());
            pstm.setInt(2, obj.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pstm);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM department WHERE Id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pstm);
        }
    }

    @Override
    public Department findById(Integer id) {
        String sql = "SELECT * FROM department " +
                "WHERE Id = ?";
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            if (rset.next()) {
                Department dep = new Department();
                dep.setId(rset.getInt("Id"));
                dep.setName(rset.getString("Name"));
                return dep;
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pstm);
            DB.closeResultSet(rset);
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            List<Department> list = new ArrayList<>();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Department dep = new Department();
                dep.setId(rset.getInt("Id"));
                dep.setName(rset.getString("Name"));
                list.add(dep);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pstm);
            DB.closeResultSet(rset);
        }
    }
}
