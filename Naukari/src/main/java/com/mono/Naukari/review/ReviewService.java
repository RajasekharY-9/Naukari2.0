package com.mono.Naukari.review;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ReviewService {

   String  createReview(Integer companyId, Review review);
    String deleteReview(Integer companyId,Integer id);

    String updateReview(Integer companyId,Integer id, Review review);

    List<Review> findAllReviews();
    List<Review> getReview(Integer companyId);

    Review getReviewbyId(Integer companyId, Integer id);

}
