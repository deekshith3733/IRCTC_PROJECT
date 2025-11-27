package com.example.IRTC.booking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PassengerBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBerthPreference() {
		return berthPreference;
	}
	public void setBerthPreference(String berthPreference) {
		this.berthPreference = berthPreference;
	}
	public String getSeatAllocated() {
		return seatAllocated;
	}
	public void setSeatAllocated(String seatAllocated) {
		this.seatAllocated = seatAllocated;
	}
	private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private String seatAllocated;
}
