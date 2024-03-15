package com.mono.Naukari.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comp/{companyId}")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/review-create")
    String  createReview(@PathVariable Integer companyId ,@RequestBody Review review){
        return  reviewService.createReview(companyId, review);
    }

    @GetMapping("/review")
    List<Review> getReviews(@PathVariable Integer companyId){
        return reviewService.getReview(companyId);
    }




    @PutMapping("/review/{id}/update")
    String updateReview(@PathVariable Integer companyId,@PathVariable Integer id,@RequestBody Review review){
        return reviewService.updateReview(companyId,id,review);
    }

    @GetMapping("review-all")
    List<Review> findAllReviews( ){
        return reviewService.findAllReviews();
    }
    @GetMapping("/rev/{id}")
    Review getReviewbyId(@PathVariable Integer companyId,@PathVariable Integer id){
        return reviewService.getReviewbyId(companyId,id);
    }

    @DeleteMapping("/del/{id}")
    String deleteReview(@PathVariable Integer comapnyId, Integer id){
        reviewService.deleteReview(comapnyId,id);
        return "Review deleted";
    }


}
