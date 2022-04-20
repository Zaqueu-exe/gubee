package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loardProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loardProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public  static void closeConnection(){
        if(conn != null){
            try {
                conn.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static  void closeStatement(PreparedStatement pstm){
        if(pstm != null){
            try{
                pstm.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
    public static  void closeResultSet(ResultSet rset){
        if(rset != null){
            try{
                rset.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }
}
