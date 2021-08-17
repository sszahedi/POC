package com.hexaware.poc.controller;

import com.hexaware.poc.entity.Job;
import com.hexaware.poc.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping()
    public ResponseEntity<Collection<Job>> getAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }
}
