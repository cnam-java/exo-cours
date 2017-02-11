package DAO;

import main.Account;

public interface DAO<T> {

	public T find(Object id) throws DAOException;
	public void create(Account a) throws DAOException;
	public void update(T obj) throws DAOException;
	public void delete(T obj) throws DAOException;
}
