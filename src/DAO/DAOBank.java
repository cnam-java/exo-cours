package DAO;

import org.apache.log4j.Logger;

import main.Bank;

public class DAOBank implements DAO<Bank> {

	private static final Logger LOG = Logger.getLogger(DAOBank.class.getName());
	private static final String URL = "jdbc:mysql://localhost/cnam?useSSL=false";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";

	public DAOBank() {
	}

	@Override
	public Bank find(Object id) throws DAOException {
		return null;
	}

	@Override
	public void create(Object T) throws DAOException {
		
	}

	@Override
	public void update(Object T) throws DAOException {
		
	}

	@Override
	public void delete(Object T) throws DAOException {
		
	}

}
