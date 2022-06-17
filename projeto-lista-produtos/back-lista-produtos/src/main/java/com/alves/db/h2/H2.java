package com.alves.db.h2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class H2 {


    private static final String createTableProductSQL =
            "CREATE  TABLE  product ( " +
                    "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name varchar(50), " +
                    "description varchar(200), " +
                    "targetmarket varchar(200) " +
                    ");";

    private static final String createTableTechnologySQL =
            "CREATE  TABLE  technology ( " +
                    "id int NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    "name varchar(200) " +
                    ");";

    private static final String createTableProductUseTechnology =
            "CREATE TABLE productusetechnology ( " +
                    "id int NOT NULL AUTO_INCREMENT, " +
                    "product_id int DEFAULT NULL, " +
                    "technology_id int DEFAULT NULL, " +
                    "PRIMARY KEY (id) " +
                    ");";

    private static final String foreignkey1 =
            "ALTER TABLE productusetechnology " +
                    "ADD FOREIGN KEY(product_id) " +
                    "REFERENCES product(id);";

    private static final String foreignkey2 =
            "ALTER TABLE productusetechnology " +
                    "ADD FOREIGN KEY(technology_id) " +
                    "REFERENCES technology(id);";

    public static void createTables() throws SQLException {

        Connection conn = DBH2.getConnection();
        try (Statement stm = conn.createStatement()) {
            stm.execute(createTableProductSQL);
            stm.execute(createTableTechnologySQL);
            stm.execute(createTableProductUseTechnology);
            stm.execute(foreignkey1);
            stm.execute(foreignkey2);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}