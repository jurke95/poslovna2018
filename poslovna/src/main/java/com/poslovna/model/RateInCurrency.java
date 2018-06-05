package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RateInCurrency implements Serializable {
	
	@Id
	private Long Id;
	
	@Column(columnDefinition="Decimal(9,4)")
	private Long buying;
	
	@Column(columnDefinition="Decimal(9,4)")
	private Long average;
	
	@Column(columnDefinition="Decimal(9,4)")
	private Long selling;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	

	public Long getBuying() {
		return buying;
	}

	public void setBuying(Long buying) {
		this.buying = buying;
	}

	public Long getAverage() {
		return average;
	}

	public void setAverage(Long average) {
		this.average = average;
	}

	public Long getSelling() {
		return selling;
	}

	public void setSelling(Long selling) {
		this.selling = selling;
	}

	
	

}
