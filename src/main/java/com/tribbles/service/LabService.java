package com.tribbles.service;

import com.tribbles.dao.LabDao;
import com.tribbles.model.Lab;

/**
 * Service for Lab
 */
public class LabService {

    LabDao labDao = new LabDao();

    public int save(Lab lab){
        return labDao.save(lab);
    }

    public Lab read(Integer labId){
        return labDao.read(labId);
    }

    public int update(Lab lab){
        return labDao.update(lab);
    }

    public int delete(Integer labId){
        return labDao.delete(labId);
    }
}
