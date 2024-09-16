package com.bliss.www.controler;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bliss.www.model.Image;
import com.bliss.www.service.ImageService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "https://hostel-management-system1.netlify.app/")
@ComponentScan(basePackages = {"com.bliss.www.controller", "com.bliss.www.service"})
@RequestMapping("/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    // Upload three images for the same entity
    @PostMapping("/upload")
    public ResponseEntity<String> uploadImages(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3") MultipartFile file3) {
        try {
            Image savedImage = imageService.saveImages(id, file1, file2, file3);
            return ResponseEntity.ok("Images uploaded successfully. Image ID: " + savedImage.getId());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Image upload failed: " + e.getMessage());
        }
    }

    // Retrieve image based on its ID and specify which image to retrieve
    @GetMapping("/{id}/{imageType}")
    public ResponseEntity<Resource> getImage(
            @PathVariable Long id,
            @PathVariable String imageType) {
        Optional<Image> imageOptional = imageService.getImage(id);
        if (imageOptional.isPresent()) {
            Image image = imageOptional.get();
            byte[] imageData;
            String imageName;
            String contentType;

            // Determine which image to retrieve
            if ("file1".equals(imageType)) {
                imageData = image.getData1();
                imageName = image.getName1();
                contentType = image.getContentType1();
            } else if ("file2".equals(imageType)) {
                imageData = image.getData2();
                imageName = image.getName2();
                contentType = image.getContentType2();
            } else if ("file3".equals(imageType)) {
                imageData = image.getData3();
                imageName = image.getName3();
                contentType = image.getContentType3();
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
            }

            if (imageData != null) {
                ByteArrayResource resource = new ByteArrayResource(imageData);
                return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageName + "\"")
                    .contentType(org.springframework.http.MediaType.parseMediaType(contentType))
                    .contentLength(imageData.length)
                    .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
        }
    }
}
