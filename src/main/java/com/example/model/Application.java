package com.example.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

@Entity
@Table
public class Application {


	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String dateOfJoining;
	    private String roomNumber;
	    private String name;
	    private String dateOfBirth;
	    private Integer age;
	    private String adhereNumber;
	    private String address;
	    private String candidateMobileNumber;
	    private String parentMobileNumber;
	    private String purposeOfJoining;
	    private Boolean vehicle;
	    private String vehicleNumber;
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDateOfJoining() {
			return dateOfJoining;
		}
		public void setDateOfJoining(String dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}
		public String getRoomNumber() {
			return roomNumber;
		}
		public void setRoomNumber(String roomNumber) {
			this.roomNumber = roomNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getAdhereNumber() {
			return adhereNumber;
		}
		public void setAdhereNumber(String adhereNumber) {
			this.adhereNumber = adhereNumber;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCandidateMobileNumber() {
			return candidateMobileNumber;
		}
		public void setCandidateMobileNumber(String candidateMobileNumber) {
			this.candidateMobileNumber = candidateMobileNumber;
		}
		public String getParentMobileNumber() {
			return parentMobileNumber;
		}
		public void setParentMobileNumber(String parentMobileNumber) {
			this.parentMobileNumber = parentMobileNumber;
		}
		public String getPurposeOfJoining() {
			return purposeOfJoining;
		}
		public void setPurposeOfJoining(String purposeOfJoining) {
			this.purposeOfJoining = purposeOfJoining;
		}
		public Boolean getVehicle() {
			return vehicle;
		}
		public void setVehicle(Boolean vehicle) {
			this.vehicle = vehicle;
		}
		public String getVehicleNumber() {
			return vehicleNumber;
		}
		public void setVehicleNumber(String vehicleNumber) {
			this.vehicleNumber = vehicleNumber;
		}
		public Boolean getTermsConditions() {
			return termsConditions;
		}
		public void setTermsConditions(Boolean termsConditions) {
			this.termsConditions = termsConditions;
		}
		public String getNextFeeDate() {
			return nextFeeDate;
		}
		public void setNextFeeDate(String nextFeeDate) {
			this.nextFeeDate = nextFeeDate;
		}
		public String getPaymentCompleted() {
			return paymentCompleted;
		}
		public void setPaymentCompleted(String paymentCompleted) {
			this.paymentCompleted = paymentCompleted;
		}
		public String getFeeAmount() {
			return feeAmount;
		}
		public void setFeeAmount(String feeAmount) {
			this.feeAmount = feeAmount;
		}
		public String getVacatedFromHostel() {
			return vacatedFromHostel;
		}
		public void setVacatedFromHostel(String vacatedFromHostel) {
			this.vacatedFromHostel = vacatedFromHostel;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		private Boolean termsConditions;
	    private String nextFeeDate;
	    private String paymentCompleted;
	    private String feeAmount;
	    private String vacatedFromHostel;
	    private String role;
	    private String username;
}
