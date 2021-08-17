package com.hexaware.poc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "position")
    private String position;

    @Column(name = "field")
    private String field;

    @Column(name = "seniority")
    private String seniority;
}
