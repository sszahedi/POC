package com.hexaware.poc.dao;

import com.hexaware.poc.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobDao extends JpaRepository<Job, Integer> {
}
