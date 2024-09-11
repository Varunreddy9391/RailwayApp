
package com.bliss.www.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bliss.www.model.Application;
import com.bliss.www.repository.ApplicationRepository;

@Service
public class ApplicationService {

	@Autowired
    private ApplicationRepository applicationRepository;

    public Application saveApplication(Application application) {
        String dateOfJoining = application.getDateOfJoining();
        if (dateOfJoining != null) {
            try {
                // Define the date format
            	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            	// Parse dateOfJoining to LocalDate
            	LocalDate joiningDate = LocalDate.parse(dateOfJoining, formatter);

            	// Calculate nextFeeDate (e.g., the same day in the next month)
            	LocalDate nextFeeDate = joiningDate.plusMonths(1);

            	// Convert nextFeeDate back to String
            	String nextFeeDateString = nextFeeDate.format(formatter);
            	application.setNextFeeDate(nextFeeDateString);
            	application.setPaymentCompleted("yes");
            } catch (DateTimeParseException e) {
                // Handle parsing error
                System.err.println("Invalid date format: " + e.getMessage());
                // Optionally throw an exception or handle it according to your application's needs
            }
        }
        // Save the application
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    public boolean vacateApplicationById(Long id) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if (applicationOptional.isPresent()) {
            Application application = applicationOptional.get();
            
            // Only update if vacatedFromHostel is currently "false"
            if ("false".equals(application.getVacatedFromHostel())) {
                application.setVacatedFromHostel("true"); // Set to "true"
                applicationRepository.save(application); // Save the updated entity
                return true;
            }
            return false; // No update needed
        }
        return false; // Entity not found
    }
    public Application updateApplication(Long id, Application application) {
        if (applicationRepository.existsById(id)) {
            application.setId(id); // Ensure the ID is set to the correct one
            application.setNextFeeDate(application.getNextFeeDate());
            application.setAddress(application.getAddress());
            application.setAdhereNumber(application.getAdhereNumber());
            application.setAge(application.getAge());
            application.setCandidateMobileNumber(application.getCandidateMobileNumber());
            application.setDateOfBirth(application.getDateOfBirth());
            application.setDateOfJoining(application.getDateOfJoining());
            application.setName(application.getName());
            application.setRoomNumber(application.getRoomNumber());
            application.setVehicleNumber(application.getVehicleNumber());
            application.setParentMobileNumber(application.getParentMobileNumber());
            application.setPurposeOfJoining(application.getPurposeOfJoining());
            application.setPaymentCompleted(application.getPaymentCompleted()); 	
            return applicationRepository.save(application);
        }
        return null; // Return null if the application does not exist
    }
    public Application getApplicationByUsernameAndPassword(String username, String password) {
        return applicationRepository.findByUsernameAndPassword(username, password);
    }
    public List<Application> getVacatedApplications() {
        return applicationRepository.findByVacatedFromHostel("true");
    }
}
