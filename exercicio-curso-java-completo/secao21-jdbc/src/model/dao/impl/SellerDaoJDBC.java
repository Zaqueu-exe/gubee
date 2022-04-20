package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {
    private Connection conn;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {
        String sql = "INSERT INTO seller " +
                "(Name, Email, BirthDate, BaseSalary, DepartmentId) " +
                "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, obj.getName());
            pstm.setString(2, obj.getEmail());
            pstm.setDate(3, new Date(obj.getBithDate().getTime()));
            pstm.setDouble(4, obj.getBaseSalary());
            pstm.setInt(5, obj.getDepartment().getId());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
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
        } finally {
            DB.closeStatement(pstm);
        }
    }

    @Override
    public void update(Seller obj) {
        String sql = "UPDATE seller " +
                "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " +
                "WHERE Id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, obj.getName());
            pstm.setString(2, obj.getEmail());
            pstm.setDate(3, new Date(obj.getBithDate().getTime()));
            pstm.setDouble(4, obj.getBaseSalary());
            pstm.setInt(5, obj.getDepartment().getId());
            pstm.setInt(6, obj.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pstm);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM seller WHERE Id = ?";
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(pstm);
        }
    }

    @Override
    public Seller findById(Integer id) {
        String sql = "SELECT seller.*, department.Name as DepName " +
                "FROM seller INNER JOIN department " +
                "ON seller.DepartmentId = department.Id " +
                "WHERE seller.Id = ?";
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            if (rset.next()) {
                Department dep = instantiateDepartment(rset);
                Seller obj = instantiateSeller(rset, dep);
                return obj;
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
    public List<Seller> findAll() {
        String sql = "SELECT seller.*, department.Name as DepName " +
                "FROM seller INNER JOIN department " +
                "ON seller.DepartmentId = department.Id " +
                "ORDER BY Name";
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rset.next()) {
                Department dep = map.get(rset.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rset);
                    map.put(rset.getInt("DepartmentId"), dep);
                }
                Seller obj = instantiateSeller(rset, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(pstm);
            DB.closeResultSet(rset);
        }
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        String sql = "SELECT seller.*, department.Name as DepName " +
                "FROM seller INNER JOIN department " +
                "ON seller.DepartmentId = department.Id " +
                "WHERE DepartmentId = ? " +
                "ORDER BY Name";
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, department.getId());
            rset = pstm.executeQuery();

            List<Seller> list = new ArrayList<>();
            Map<Integer, Department> map = new HashMap<>();

            while (rset.next()) {
                Department dep = map.get(rset.getInt("DepartmentId"));

                if (dep == null) {
                    dep = instantiateDepartment(rset);
                    map.put(rset.getInt("DepartmentId"), dep);
                }
                Seller obj = instantiateSeller(rset, dep);
                list.add(obj);
            }
            return list;
        } catch (SQLException e) {
            return null;
        } finally {
            DB.closeStatement(pstm);
            DB.closeResultSet(rset);
        }
    }

    private Seller instantiateSeller(ResultSet rset, Department dep) throws SQLException {
        Seller obj = new Seller();
        obj.setId(rset.getInt("Id"));
        obj.setName(rset.getString("Name"));
        obj.setEmail(rset.getString("Email"));
        obj.setBaseSalary(rset.getDouble("BaseSalary"));
        obj.setBithDate(rset.getDate("BirthDate"));
        obj.setDepartment(dep);
        return obj;
    }

    private Department instantiateDepartment(ResultSet rset) throws SQLException {
        Department dep = new Department();
        dep.setId(rset.getInt("DepartmentId"));
        dep.setName(rset.getString("DepName"));
        return dep;
    }


}
