package com.hexaware.poc.service;

import com.hexaware.poc.dao.JobDao;
import com.hexaware.poc.entity.Job;
import com.hexaware.poc.entity.User;
import com.hexaware.poc.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private final JobDao jobDao;

    @Autowired
    public JobService(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    public List<Job> findAll() {
        return jobDao.findAll();
    }

    public Job findOne(Integer jobId) {
        return jobDao.findById(jobId).orElseThrow(
                () -> new NotFoundException(
                        "job with id " + jobId + " not found"));
    }
}
