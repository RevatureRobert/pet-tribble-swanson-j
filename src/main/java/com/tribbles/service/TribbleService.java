package com.tribbles.service;

import com.tribbles.dao.LabDao;
import com.tribbles.dao.TribbleDao;
import com.tribbles.model.Lab;
import com.tribbles.model.Tribble;

/**
 * Service for Tribble
 */
public class TribbleService {

    TribbleDao tribbleDao = new TribbleDao();

    public int save(Tribble tribble){
        return tribbleDao.save(tribble);
    }

    public Tribble read(Integer tribbleId){
        return tribbleDao.read(tribbleId);
    }

    public int update(Tribble tribble){
        return tribbleDao.update(tribble);
    }

    public int delete(Integer tribbleId){
        return tribbleDao.delete(tribbleId);
    }
}