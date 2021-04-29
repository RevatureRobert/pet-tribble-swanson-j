package com.tribbles.service;

import com.tribbles.dao.LabDao;
import com.tribbles.model.Lab;

/**
 * Service for Lab
 */
public class LabService {

    LabDao labDao = new LabDao();

    int save(Lab lab){
        return labDao.save(lab);
    }

    int read(Integer labId){
        return labDao.read(labId);
    }

    int update(Lab lab){
        return labDao.update(lab);
    }

    int delete(Integer labId){
        return labDao.delete(labId);
    }
}
