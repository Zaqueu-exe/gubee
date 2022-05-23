package com.alves.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

class DBTest {

    @Test
    void connectionWithTheDataBase() {
        Connection conn = DB.getConnection();
        assertNotNull(conn, "connection should be successfull.");
    }
}