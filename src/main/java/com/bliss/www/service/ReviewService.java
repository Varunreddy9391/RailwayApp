package com.bliss.www.service;

import java.util.List;

import com.bliss.www.model.Review;

public interface ReviewService {

	Review createReview(Review review);
    List<Review> getAllReviews();
    Review getReviewById(Long id);
    Review updateReview(Long id, Review reviewDetails);
    void deleteReview(Long id);
}
