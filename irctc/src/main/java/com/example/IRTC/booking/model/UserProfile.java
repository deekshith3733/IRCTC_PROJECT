package com.example.IRTC.booking.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserProfile {
	@Id
	@Column(name = "user_profile_id")
	public Integer userProfileId;
	
	
	@Column(name = "user_full_name")
	public String userFullName;
	
	
	@Column(name = "user_first_name")
	public String userFirstName;
	
	@Column(name = "user_last_name")
	public String userLastName;
	
	@Column(name = "DOB")
	public Instant dob;
	
	@Column(name = "user_type")
	public Integer user_type_id;
	
	@Column(name = "user_login_id")
	public Integer userLoginId;
	
	@Column(name = "is_active")
	public Boolean isactive;

	public Integer getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Integer userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public Instant getDob() {
		return dob;
	}

	public void setDob(Instant dob) {
		this.dob = dob;
	}

	public Integer getUser_type_id() {
		return user_type_id;
	}

	public void setUser_type_id(Integer user_type_id) {
		this.user_type_id = user_type_id;
	}

	public Integer getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(Integer userLoginId) {
		this.userLoginId = userLoginId;
	}

	public Boolean getIsactive() {
		return isactive;
	}

	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	
	
	
}
