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

    int save(Tribble tribble){
        return tribbleDao.save(tribble);
    }

    int read(Integer tribbleId){
        return tribbleDao.read(tribbleId);
    }

    int update(Tribble tribble){
        return tribbleDao.update(tribble);
    }

    int delete(Integer tribbleId){
        return tribbleDao.delete(tribbleId);
    }
}