package com.example.domain;

import com.example.domain.dao.AbstractDaoFactory;
import com.example.domain.dao.DAOFactory;

public class MakeDao {
    
    public static AbstractDaoFactory createDaoJDBC(){
        return new DAOFactory();
    }
}
