package DAO;

public interface DAO<T> {

	public T find(Object id) throws DAOException;
	public void create(Object T) throws DAOException;
	public void update(Object T) throws DAOException;
	public void delete(Object T) throws DAOException;
}
