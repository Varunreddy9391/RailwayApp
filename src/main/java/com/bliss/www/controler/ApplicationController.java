package com.bliss.www.controler;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bliss.www.model.Application;
import com.bliss.www.service.ApplicationService;

@CrossOrigin(origins = "https://hostel-management-system1.netlify.app/")
@ComponentScan(basePackages = {"com.bliss.www.controller", "com.bliss.www.service"})
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

    @DeleteMapping("/vacate/{id}")
    public ResponseEntity<Void> vacateApplication(@PathVariable Long id) {
        boolean isUpdated = applicationService.vacateApplicationById(id);
        if (isUpdated) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
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
     
    @GetMapping("/vacated")
    public List<Application> getVacatedApplications() {
        return applicationService.getVacatedApplications();
    }
    
    @PostMapping("/login")
    public ResponseEntity<Application> login(@RequestBody Application application) {
        Application loggedInUser = applicationService.loginByUsernameAndPassword(application.getUsername(), application.getPassword());

        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Unauthorized
        }
    }
    @PostMapping("/reset-password")
    public String Application(@RequestBody Application request) {
        boolean isReset = applicationService.Application(request.getUsername(), request.getEmail(), request.getPassword());
        if (isReset) {
            return "Password reset successfully.";
        } else {
            return "Invalid username or email.";
        }
    }

     
}
