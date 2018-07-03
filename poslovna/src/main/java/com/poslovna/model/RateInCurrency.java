package com.poslovna.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	
	
	@ManyToOne
	private Currency primary;
	
	@ManyToOne
	private Currency changeto;
	
	
	
	

	public RateInCurrency(Long buying, Long average, Long selling, Currency primary, Currency changeto) {
		super();
		this.buying = buying;
		this.average = average;
		this.selling = selling;
		this.primary = primary;
		this.changeto = changeto;
	}

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

	public Currency getPrimary() {
		return primary;
	}

	public void setPrimary(Currency primary) {
		this.primary = primary;
	}

	public Currency getChangeto() {
		return changeto;
	}

	public void setChangeto(Currency changeto) {
		this.changeto = changeto;
	}

	
	

}
