package com.alves.domain;

import com.alves.domain.dao.AbstractDaoFactory;
import com.alves.domain.dao.DAOFactory;

public class MakeDao {
    
    public static AbstractDaoFactory createDaoJDBC(){
        return new DAOFactory();
    }
}
