package com.poslovna.controller.dto;

public class ClientReportDTO {

	
	
	
	private String accountnum;
	private String datefrom;
	private String dateto;
	
	
	public ClientReportDTO(){
		
	}
	
	
	
	
	
	
	public ClientReportDTO(String accountnum, String datefrom, String dateto) {
		
		this.accountnum = accountnum;
		this.datefrom = datefrom;
		this.dateto = dateto;
	}






	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public String getDatefrom() {
		return datefrom;
	}
	public void setDatefrom(String datefrom) {
		this.datefrom = datefrom;
	}
	public String getDateto() {
		return dateto;
	}
	public void setDateto(String dateto) {
		this.dateto = dateto;
	}
	
	
	
}
