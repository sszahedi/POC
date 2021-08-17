package com.hexaware.poc.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @NonNull
    private String title;

    @Column(name = "position")
    @NonNull
    private String position;

    @Column(name = "field")
    @NonNull
    private String field;

    @Column(name = "seniority")
    @NonNull
    private String seniority;

    public Job(
            String title,
            String position,
            String field,
            String seniority
    ) {
        this.title = title;
        this.position = position;
        this.field = field;
        this.seniority = seniority;
    }
}
