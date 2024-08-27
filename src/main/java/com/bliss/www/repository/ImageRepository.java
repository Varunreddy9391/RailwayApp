package com.bliss.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bliss.www.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
