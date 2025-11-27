package com.example.IRTC.booking.model;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Table(name = "user_login_details")
@Entity
public class UserLoginDetails {
	
	@Id
	@Column(name = "user_login_detail_id")
	 public Integer userLoginDetailId;
	
	@Column(name = "mobile_number")
	public String mobileNumber;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "created_at")
	public Instant createdAt;
	
	@Column(name = "updated_at")
	public Instant updatedAt;

	public Integer getUserLoginDetailId() {
		return userLoginDetailId;
	}

	public void setUserLoginDetailId(Integer userLoginDetailId) {
		this.userLoginDetailId = userLoginDetailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
}
