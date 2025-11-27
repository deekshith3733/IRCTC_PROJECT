package com.example.IRTC.booking.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.IRTC.booking.model.UserLoginDetails;

@Repository
public interface UserLoginDetailsRepository  extends JpaRepository<UserLoginDetails, Integer>{

	UserLoginDetails findByMobileNumber(String mobileNumber);

	UserLoginDetails findByMobileNumberAndPassword(String mobileNumber, String password);

}
