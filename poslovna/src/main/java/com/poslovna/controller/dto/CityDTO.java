package com.poslovna.controller.dto;

public class CityDTO {
	
	public CityDTO(String name, String code, String countryS, String postNum) {
		super();
		this.name = name;
		this.code = code;
		this.countryS = countryS;
		this.postNum = postNum;
	}

	public CityDTO() {
		
	}
	
	

	private String name;
	
	private String code;
	
	private String countryS;
	
	private String postNum;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getCountryS() {
		return countryS;
	}

	public void setCountryS(String countryS) {
		this.countryS = countryS;
	}

}
