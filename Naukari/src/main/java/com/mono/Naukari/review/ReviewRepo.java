package com.mono.Naukari.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review,Integer> {
    List<Review> findByCompanyId(Integer companyId);
}
