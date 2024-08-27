package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Application;
import com.example.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController  {
   
	@Autowired
    private ApplicationService applicationService;

    @PostMapping("/addapplication")
    public ResponseEntity<Application> createApplication(@RequestBody Application application) {
    	
    	
    	
    	
        Application savedApplication = applicationService.saveApplication(application);
        return ResponseEntity.ok(savedApplication);
    }

    @GetMapping("/getapplication")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Application>> getApplicationById(@PathVariable Long id) {
        Optional<Application> application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(application);
    }

    @DeleteMapping("/status/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application application) {
        if (!id.equals(application.getId())) {
            return ResponseEntity.badRequest().build(); // Return bad request if IDs don't match
        }

        Application updatedApplication = applicationService.updateApplication(id, application);

        if (updatedApplication != null) {
            return ResponseEntity.ok(updatedApplication);
        } else {
            return ResponseEntity.notFound().build(); // Return not found if the application does not exist
        }
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<Application> getByUsername(@PathVariable String username) {
        return applicationService.findByUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
     
}
