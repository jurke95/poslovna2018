package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LegalEntity {

	public LegalEntity() {
		
	}
	
	
	public LegalEntity(Long id, String name, String shortName, String location, String address, String phoneNumber,
			String fax, String email, String responsiblePerson, String activityName, String activityCode, String mbr,
			String jmbg, String taxAuthority, String taxNumber, String deliveryAddress) {
		
		this.id = id;
		this.name = name;
		this.shortName = shortName;
		this.location = location;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.fax = fax;
		this.email = email;
		this.responsiblePerson = responsiblePerson;
		this.activityName = activityName;
		this.activityCode = activityCode;
		this.mbr = mbr;
		this.jmbg = jmbg;
		this.taxAuthority = taxAuthority;
		this.taxNumber = taxNumber;
		this.deliveryAddress = deliveryAddress;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String shortName;
	
	@Column
	private String location;
	
	@Column
	private String address;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String fax;
	
	@Column
	private String email;
	
	@Column
	private String responsiblePerson;
	
	@Column
	private String activityName;
	
	@Column
	private String activityCode;
	
	@Column
	private String mbr;
	
	@Column
	private String jmbg;
	
	@Column
	private String taxAuthority;
	
	@Column
	private String taxNumber;
	
	/* ????
	@Column
	private String pib;
	*/
	
	@Column
	private String deliveryAddress;

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

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getMbr() {
		return mbr;
	}

	public void setMbr(String mbr) {
		this.mbr = mbr;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getTaxAuthority() {
		return taxAuthority;
	}

	public void setTaxAuthority(String taxAuthority) {
		this.taxAuthority = taxAuthority;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	
	
}
