package com.tribbles.dao;

import com.tribbles.model.Lab;
import com.tribbles.model.Tribble;

/**
 * DAO for Tribbles used to perform CRUD operations using JDBC
 */
public class LabDao implements InterfaceDao<Lab, Integer>{

    @Override
    public int save(Lab lab) {
        return 0;
    }

    @Override
    public int read(Integer id) {
        return 0;
    }

    @Override
    public int update(Lab lab) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
