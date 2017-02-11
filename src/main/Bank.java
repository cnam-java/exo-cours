package main;

import java.util.LinkedList;

public class Bank {
	private int id;
	private String nom;
	private LinkedList<Account> bankAccounts;
	
	
	public Bank() {
		//useless
	}
	
	public String toString(){
		return "Bank "+id+" : "+nom+", "+bankAccounts+".";
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public LinkedList<Account> getBankAccounts() {
		return bankAccounts;
	}


	public void setBankAccounts(LinkedList<Account> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	public void addAccount (Account a){
		bankAccounts.add(a);
	}
	
	public void removeAccount (Account a){
		bankAccounts.remove(a);
	}

}
