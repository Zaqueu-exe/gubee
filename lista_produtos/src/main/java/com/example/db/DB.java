package com.example.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private  static Connection conn = null;

    public static Connection getConnection(){
        if(conn == null){
            try {
                Properties props = loadProperties();
                String dburl = props.getProperty("dburl");
                conn = DriverManager.getConnection(dburl, props);
            }catch (SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("src/main/resources/db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if(conn!= null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closePreparedStatement(PreparedStatement pstm){
        if(pstm!= null){
            try {
                pstm.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeResultSet(ResultSet rset){
        if(rset!= null){
            try {
                rset.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
