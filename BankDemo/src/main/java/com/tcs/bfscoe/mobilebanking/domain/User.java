package com.tcs.bfscoe.mobilebanking.domain;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {

	@Id
	private String id;
	@Field
	@NotEmpty(message="$")
	private String userid;
	@Field
	@NotEmpty(message="$")
	private String firstName;
	@Field
	private String lastName;
	@Field
	@NotEmpty(message="$")
	@Range(message="$", min=5, max=120)
	private int age;
	@Field
	private String birthday;
	@Field
	private String currency;
	@Field
	private String[] devices;
	@Field
	private String[] education;
	@Field
	@NotEmpty(message="$")
	private String email;
	@Field
	@NotEmpty(message="$")
	private String gender;
	@Field
	private String hometown;
	@Field
	private String location;
	@Field
	private String[] languages;
	@Field
	private String relationshipStatus;
	@Field
	private String religion;
	@Field
	private String timeZone;
	@Field
	private String[] work;
	@Field
	private boolean isCustomer;
	@Field
	private String cover;
	@Field 
	private String referredBy;	
	@Field
	private String[] refPreferences;
	@Field
	private String[] instPreferences;
	
	
	public String[] getRefPreferences() {
		return refPreferences;
	}

	public void setRefPreferences(String[] refPreferences) {
		this.refPreferences = refPreferences;
	}

	public String[] getInstPreferences() {
		return instPreferences;
	}

	public void setInstPreferences(String[] instPreferences) {
		this.instPreferences = instPreferences;
	}

	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	
	public String[] getDevices() {
		return devices;
	}

	public void setDevices(String[] devices) {
		this.devices = devices;
	}

	public String[] getEducation() {
		return education;
	}

	public void setEducation(String[] education) {
		this.education = education;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String getRelationshipStatus() {
		return relationshipStatus;
	}

	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String[] getWork() {
		return work;
	}

	public void setWork(String[] work) {
		this.work = work;
	}

	public boolean getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getReferredBy() {
		return referredBy;
	}

	public void setReferredBy(String referredBy) {
		this.referredBy = referredBy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	@Override
	public String toString(){
		return firstName + " " + lastName + " with emailid " + email;
	}
}
