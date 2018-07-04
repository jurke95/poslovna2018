package com.poslovna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LegalEntity {

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
	
	
	
}
