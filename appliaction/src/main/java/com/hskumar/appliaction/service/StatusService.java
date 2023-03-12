package com.hskumar.appliaction.service;

import com.hskumar.appliaction.dao.IStatusRepository;
import com.hskumar.appliaction.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    IStatusRepository repository;
    public int saveStatus(Status status){
        Status statusObj=repository.save(status);
        return statusObj.getStatusId();
    }

}

