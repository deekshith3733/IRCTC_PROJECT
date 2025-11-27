package com.example.IRTC.booking.model;


import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserType {

	@Id
	@Column(name = "user_type_id")
	private Integer userTypeId;

	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "created_at")
	private Instant createdAt;
	
	@Column(name = "updated_at")
	private Instant updatedAt;
}
