package com.example.IRTC.booking.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "train_routes")
public class Train {

    @Id
    private String trainNo;

    private String name;

    public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TrainRoute> getRoute() {
		return route;
	}
	public void setRoute(List<TrainRoute> route) {
		this.route = route;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getQuotas() {
		return quotas;
	}
	public void setQuotas(String quotas) {
		this.quotas = quotas;
	}
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_no")   // FK column in train_route table
    private List<TrainRoute> route;

    private String classes;
    private String quotas;
}
