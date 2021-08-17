package com.hexaware.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    @NotBlank(message = "title must not be empty")
    private String title;

    @Column(name = "position")
    @NotBlank(message = "position must not be empty")
    private String position;

    @Column(name = "field")
    @NotBlank(message = "field must not be empty")
    private String field;

    @Column(name = "seniority")
    @NotBlank(message = "seniority must not be empty")
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
