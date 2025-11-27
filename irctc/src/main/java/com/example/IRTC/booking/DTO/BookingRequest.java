package com.example.IRTC.booking.DTO;

import java.time.LocalDate;
import java.util.List;

import com.example.IRTC.booking.model.Passenger;

import lombok.Data;

@Data
public class BookingRequest {

    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	private Long userId;
    private String trainNo;
    private LocalDate date;
    private String cls;
    private String quota;

    private List<Passenger> passengers;
}
