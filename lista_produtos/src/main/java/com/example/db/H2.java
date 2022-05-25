package com.example.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2 {


    private  static  final  String createTableProdutoSQL =
            "CREATE  TABLE  produto ( "  +
            "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, "  +
            "nome varchar(50), "  +
            "descricao varchar(200), "  +
            "mercadoalvo varchar(200) "  +
            ");";

    private  static  final  String createTableTecnologiaSQL =
            "CREATE  TABLE  tecnologia ( "  +
            "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, "  +
            "nome varchar(200) "  +
            ");";

    private static final String createTableProdutoUseTecnologia =
            "CREATE TABLE produtousetecnologia ( " +
            "id int NOT NULL AUTO_INCREMENT, "+
            "produto_id int DEFAULT NULL, "+
            "tecnologia_id int DEFAULT NULL, "+
            "PRIMARY KEY (id) " +
            ");";

    private static final String foreignkey1 =
            "ALTER TABLE produtousetecnologia "+
            "ADD FOREIGN KEY(produto_id) "+
            "REFERENCES produto(id);";

    private static final String foreignkey2 =
            "ALTER TABLE produtousetecnologia "+
                    "ADD FOREIGN KEY(tecnologia_id) "+
                    "REFERENCES tecnologia(id);";

    public static void createTables() throws SQLException {


         Connection conn = DB.getConnection();
         try(Statement stm = conn.createStatement()){
             stm.execute(createTableProdutoSQL);
             stm.execute(createTableTecnologiaSQL);
             stm.execute(createTableProdutoUseTecnologia);
             stm.execute(foreignkey1);
             stm.execute(foreignkey2);
         }catch (SQLException e){
             throw new RuntimeException(e.getMessage());
         }
     }

}