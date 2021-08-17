package com.hexaware.poc.service;

import com.hexaware.poc.dao.JobDao;
import com.hexaware.poc.entity.Job;
import com.hexaware.poc.entity.User;
import com.hexaware.poc.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class JobService {

    private final JobDao jobDao;

    @Autowired
    public JobService(JobDao jobDao) {
        this.jobDao = jobDao;
    }

    public List<Job> findAll() {
        log.info("findAll : JobService");
        return jobDao.findAll();
    }

    public Job findOne(Integer jobId) {
        log.info("findOne : JobService");
        return jobDao.findById(jobId).orElseThrow(
                () -> new NotFoundException(
                        "job with id " + jobId + " not found"));
    }
}
