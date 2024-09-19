package com.bliss.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bliss.www.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findAllByOrderByIdDesc();
}
