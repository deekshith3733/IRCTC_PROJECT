package com.example.IRTC.booking.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pnr;
    private String trainNo;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String status;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public List<PassengerBooking> getPassengerDetails() {
		return passengerDetails;
	}

	public void setPassengerDetails(List<PassengerBooking> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	private String paymentStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id") 
    private List<PassengerBooking> passengerDetails;
}
