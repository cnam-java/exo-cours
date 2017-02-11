package main;

public class Account {
	private int id;
	private String first_name;
	private String last_name;
	private double amount;
	private int idBank;
	
	
	public Account() {
		//useless
	}
	
	public String toString(){
		return "Account "+id+" : "+first_name+", "+last_name+", "+amount+".";
	}
	
	public int getIdBank() {
		return idBank;
	}

	public void setIdBank(int idBank) {
		this.idBank = idBank;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

}
