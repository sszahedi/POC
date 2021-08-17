package com.hexaware.poc.controller;

import com.hexaware.poc.entity.Job;
import com.hexaware.poc.service.JobService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@Slf4j
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping()
    public ResponseEntity<List<Job>> getAll() {
        log.info("getAll : JobController");
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getOne(@PathVariable Integer jobId) {
        log.info("getOne : JobController");
        return new ResponseEntity<>(jobService.findOne(jobId), HttpStatus.NOT_FOUND);
    }
}
