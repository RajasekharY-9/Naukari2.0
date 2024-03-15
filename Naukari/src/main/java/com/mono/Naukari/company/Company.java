package com.mono.Naukari.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mono.Naukari.job.Job;
import com.mono.Naukari.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
           // @Column(name="company_id")
    Integer id;

    String name;

    String description;

    @JsonIgnore//remove recursion call back
    @OneToMany(mappedBy = "company")
    List<Job> job;

    @OneToMany(mappedBy = "company")
    @JsonIgnore//remove recursion call back
    List<Review> reviews;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    //List<Review> reviews;
    public Company() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return job;
    }

    public void setJobs(List<Job> jobs) {
        this.job = jobs;
    }

    public Company(Integer id, String name, String description, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.job= jobs;
    }
}
