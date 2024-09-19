package com.bliss.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bliss.www.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
