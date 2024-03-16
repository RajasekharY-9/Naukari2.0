package com.mono.Naukari.review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mono.Naukari.company.Company;
import jakarta.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String comment;
    String rating;
    @JsonBackReference // Indicates the back part of the relationship
    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Review() {
    }

    public Review(Integer id, String comment, String rating, Company company) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
        this.company = company;
    }
}
