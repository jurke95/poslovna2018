package com.poslovna.controller.dto;

public class AccountClosureDTO {
	
	
	private String closuredate;
	
	private String accountto;
	
	private String accountfrom;
	
	
	public AccountClosureDTO(){
		
	}
	
	
	
	

	public AccountClosureDTO(String closuredate, String accountto, String accountfrom) {
		super();
		this.closuredate = closuredate;
		this.accountto = accountto;
		this.accountfrom = accountfrom;
	}





	public String getClosuredate() {
		return closuredate;
	}

	public void setClosuredate(String closuredate) {
		this.closuredate = closuredate;
	}

	

	public String getAccountfrom() {
		return accountfrom;
	}

	public void setAccountfrom(String accountfrom) {
		this.accountfrom = accountfrom;
	}



	public String getAccountto() {
		return accountto;
	}



	public void setAccountto(String accountto) {
		this.accountto = accountto;
	}
	
	
	
	

}
