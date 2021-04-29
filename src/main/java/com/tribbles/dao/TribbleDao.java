package com.tribbles.dao;

import com.tribbles.model.Tribble;

/**
 * DAO for Tribbles used to perform CRUD operations using JDBC
 */
public class TribbleDao implements InterfaceDao<Tribble, Integer>{

    @Override
    public int save(Tribble tribble) {
        return 0;
    }

    @Override
    public int read(Integer id) {
        return 0;
    }

    @Override
    public int update(Tribble tribble) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
