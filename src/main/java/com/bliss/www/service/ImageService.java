package com.bliss.www.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bliss.www.model.Image;
import com.bliss.www.repository.ImageRepository;

@Service
public class ImageService {

	@Autowired
    private ImageRepository imageRepository;

    // Save images for an existing image entity or create a new one
    public Image saveImages(Long id, MultipartFile file1, MultipartFile file2) throws IOException {
        Image image;
        if (id != null) {
            Optional<Image> existingImage = imageRepository.findById(id);
            if (existingImage.isPresent()) {
                image = existingImage.get();
            } else {
                throw new IllegalArgumentException("Image with id " + id + " does not exist");
            }
        } else {
            image = new Image();
        }
        
        if (file1 != null) {
            image.setData1(file1.getBytes());
            image.setContentType1(file1.getContentType());
            image.setName1(file1.getOriginalFilename());
        }
        
        if (file2 != null) {
            image.setData2(file2.getBytes());
            image.setContentType2(file2.getContentType());
            image.setName2(file2.getOriginalFilename());
        }
        
        return imageRepository.save(image);
    }

    public Optional<Image> getImage(Long id) {
        return imageRepository.findById(id);
    }
}
