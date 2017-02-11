package main;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import DAO.DAO;
import DAO.DAOAccount;
import DAO.DAOException;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class Launcher {

	private static final Logger LOG = Logger.getLogger(Launcher.class.getName());
	private Launcher() {
		// Useless
	}

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4J.properties");
		LOG.info("Chargement de l'objet...");
		DAO<Account> accountDAO = new DAOAccount();
		try{
			Account a = accountDAO.find(1);
			LOG.info(a.getFirst_name()); 
		} catch (DAOException e){
			LOG.error("Error during loading DAO user", e);
			
		}
//		System.out.println("Bienvenue ! Vous désirez :\n1-Enregistrer un compte.\n2-Afficher les comptes.\nEntrez votre choix (1 ou 2) :\n");
//		Scanner sc = new Scanner(System.in);
//		int choix = sc.nextInt();
//		try{
//			operationsAccount(choix);
//		} catch (AccountException e){
//			e.printStackTrace();
//		}
		//final Account a1 = new Account (0,"Gaël","CHENEVIER",2042.5);
		
		//try {
			//insertAccount(a1);
		//	System.out.println(chargerCompte(1));
		//	System.out.println(chargerCompte(2));
		//} catch (AccountException e) {
		//	e.printStackTrace();
		//}
	}
//	
//	private static void operationsAccount(int choix) throws AccountException{
//		Scanner sc = new Scanner(System.in);
//		String nom;
//		String prenom;
//		double montant;
//		switch(choix){
//		case 1 : System.out.println("Vous avez choisi : Enregistrer un compte.\n");
//				 System.out.println("Veuillez entrer un nom :\n");
//				 nom = sc.nextLine();	
//				 System.out.println("Veuillez entrer un prénom:\n");
//				 prenom = sc.nextLine();
//				 System.out.println("Veuillez entrer le montant sur le compte:\n");
//				 montant = sc.nextDouble();
//				 //Account a = new Account(0,prenom,nom,montant);
//				 //insertAccount(a);
//				 break;
//		case 2: System.out.println("Vous avez choisi : Afficher les comptes.\n");
//				System.out.println("Les comptes sont les suivants :\n");
//				chargerCompte();
//				break;
//		default: System.out.println("Vous deviez rentrer 1 ou 2...\n");
//		
//		}
//	}
//
//	private static void insertAccount(Account a) throws AccountException {
//		final String sql = "INSERT INTO `accounts` VALUES (NULL,?,?,?)";
//		Connection c = null;
//		PreparedStatement st = null;
//		ResultSet r = null;
//		try {
//			c = DriverManager.getConnection("jdbc:mysql://localhost/cnam?useSSL=false", "root", "root");
//			st = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//			st.setString(1, a.first_name);
//			st.setString(2, a.last_name);
//			st.setDouble(3, a.amount);
//			st.executeUpdate();
//
//			r = st.getGeneratedKeys();
//
//			if (r.next()) {
//				a.id = r.getInt(1);
//			}else{
//				throw new AccountException("Error during account insertion.");	
//			}
//		} catch (SQLException e) {
//			throw new AccountException("Error during account insertion.", e);
//		} finally {
//			try {
//				if (r != null)
//					r.close();
//				if (st != null)
//					st.close();
//				if (c != null)
//					c.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	//private static Account chargerCompte(int id) throws AccountException {
//	private static void chargerCompte() throws AccountException {
//		Connection c = null;
//		PreparedStatement st = null;
//		ResultSet r = null;
//		ArrayList<Account> accounts = new ArrayList<Account>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			c = DriverManager.getConnection("jdbc:mysql://localhost/cnam?useSSL=false", "root", "root");
//			st = c.prepareStatement("SELECT * FROM `accounts`");	
//			//st = c.prepareStatement("SELECT * FROM `accounts` WHERE `id` = ? ");
//			//st.setInt(1, id);
//			r = st.executeQuery();
//			//if (r.next()) {
//			//	return new Account(r.getInt(1), r.getString(2), r.getString(3), r.getDouble(4));
//			//}
//			while (r.next()) {
//				System.out.println((r.getInt(1)+", "+ r.getString(2)+", "+ r.getString(3)+", "+ r.getDouble(4)+"."));
//			}
//			throw new AccountException("Erreur aucun utilisateur.");
//		} catch (ClassNotFoundException e) {
//			throw new AccountException("Erreur sql connector not found.", e);
//		} catch (SQLException e) {
//			throw new AccountException("Erreur in sql request.", e);
//		} finally {
//			try {
//				if (r != null)
//					r.close();
//				if (st != null)
//					st.close();
//				if (c != null)
//					c.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
