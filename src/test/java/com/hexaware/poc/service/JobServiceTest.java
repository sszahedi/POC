package com.hexaware.poc.service;

import com.hexaware.poc.dao.JobDao;
import com.hexaware.poc.entity.Job;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class JobServiceTest {

    @Autowired
    private JobDao jobDao;

    private JobService underTest;

    @BeforeEach
    void setUp() {
        underTest = new JobService(jobDao);
    }

    @AfterEach
    void tearDown() {
        jobDao.deleteAll();
    }

    @Test
    void findAll() {
        // given
//        Job job1 = new Job(
//                1,
//                "Retail Clerk",
//                "Clerk",
//                "Retail",
//                "Beginner"
//        );
//
//        Job job2 = new Job(
//                2,
//                "Pilot",
//                "United Airlines",
//                "Aeroflight",
//                "Experience"
//        );

//        jobDao.saveAll(Arrays.asList(job1, job2));

        // when
        List<Job> jobs = underTest.findAll();

        // then
        assertEquals(10, jobs.size());
    }

    @Test
    void findOne() {
        // given
        Job job1 = new Job(
                1,
                "Retail Clerk",
                "Clerk",
                "Retail",
                "Beginner"
        );

        jobDao.save(job1);

        // when
        Job actual = underTest.findOne(1);

        // then
        assertEquals(1, actual.getId());
        assertEquals("Retail Clerk", actual.getTitle());
        assertEquals("Clerk", actual.getPosition());
        assertEquals("Retail", actual.getField());
        assertEquals("Beginner", actual.getSeniority());
    }
}