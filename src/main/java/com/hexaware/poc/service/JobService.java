package com.hexaware.poc.service;

import com.hexaware.poc.dao.JobDao;
import com.hexaware.poc.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class JobService {

    @Autowired
    JobDao jobDao;

    public Collection<Job> findAll() {
        return jobDao.findAll();
    }
}
