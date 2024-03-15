package com.mono.Naukari.review;

import com.mono.Naukari.company.Company;
import com.mono.Naukari.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {


    ReviewRepo reviewRepo;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepo reviewRepo,CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService=companyService;
    }

    @Override
    public String createReview(Integer comapnyId, Review review) {
        Company comp= companyService.getCompany(comapnyId);
        if(comp!=null) {
review.setCompany(comp);

            reviewRepo.save(review);
        }
        return "Review Created !!!";
    }

    @Override
    public String deleteReview(Integer companyId, Integer id) {
        if(companyService.getCompany(companyId)!=null) {
            reviewRepo.deleteById(id);
        }
        return "Company Deleted !!!";
    }

    @Override
    public String updateReview(Integer companyId, Integer id, Review updreview) {
       if(companyService.getCompany(companyId)!=null);
        {
       updreview.setCompany(companyService.getCompany(companyId));
updreview.setId(id);
reviewRepo.save(updreview);
        }
        return "Review details updated !!!";
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepo.findAll();


    }

    @Override
    public List<Review> getReview(Integer companyId) {
        List<Review> reviews= reviewRepo.findByCompanyId(companyId);

        return reviews;
    }

    @Override
    public Review getReviewbyId(Integer companyId, Integer id) {
        List<Review> reviews = reviewRepo.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(id))
                .findFirst()
                .orElse(null);

    }
}
