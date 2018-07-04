package com.poslovna.dto;

public class CityDTO {
	
	public CityDTO() {
		
	}
	
	public CityDTO(String name, String code, String country, String postNum) {
		
		this.name = name;
		this.code = code;
		this.country = country;
		this.postNum = postNum;
	}

	private String name;
	
	private String code;
	
	private String country;
	
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

}
