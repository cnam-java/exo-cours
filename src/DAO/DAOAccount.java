package DAO;

import main.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DAOAccount implements DAO<Account>{
	
	private static final Logger LOG = Logger.getLogger(DAOAccount.class.getName());
	private static final String URL = "jdbc:mysql://localhost/cnam?useSSL=false";
	private static final String LOGIN = "root";
	private static final String PASSWORD = "root";
	
	@Override
	public Account find(Object id) throws DAOException {
		
		if(!(id instanceof Integer)){
			throw new DAOException("Id not take in charge.");
		}
		final String sql = "SELECT * FROM `accounts` WHERE `id`= ?";
		Connection c = null;
		PreparedStatement st = null;
		ResultSet r = null;
		Account a = new Account();
		try{
			c = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			st = c.prepareStatement(sql);
			st.setInt(1, (int) id);
			r = st.executeQuery();
			if(r.next()){
				a.setId(r.getInt("id"));
				a.setAmount(r.getDouble("amount"));
				a.setFirst_name(r.getString("first_name"));
				a.setLast_name(r.getString("last_name"));
				
				return a;
			}else{
				throw new DAOException("Error no user for this id.");
			}
		}catch (SQLException e){
			throw new DAOException("Error in sql query", e);
		}finally{
			try {
				if (r != null)
					r.close();
				if (st != null)
					st.close();
				if (c != null)
					c.close();
			} catch (SQLException e) {
				LOG.error("Error during closing open connections."); 
			}
		}
	}

	@Override
	public void create(Object a) throws DAOException {
		final String sql = "INSERT INTO `accounts` VALUES (NULL,?,?,?,?)";
		Connection c = null;
    	PreparedStatement st = null;
		ResultSet r = null;
		try {
     		c = DriverManager.getConnection(URL, LOGIN, PASSWORD);
			st = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, ((Account) a).getFirst_name());
			st.setString(2, ((Account) a).getLast_name());
			st.setDouble(3, ((Account) a).getAmount());
			st.setInt(4, ((Account) a).getIdBank()); 
			st.executeUpdate();

			r = st.getGeneratedKeys();

			if (r.next()) {
				((Account) a).setId(r.getInt(1));
			}else{
				throw new DAOException("Error during account insertion.");	
			}
		} catch (SQLException e) {
			throw new DAOException("Error during account insertion.", e);
		} finally {
			try {
				if (r != null)
					r.close();
				if (st != null)
					st.close();
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Object a) {
	}

	@Override
	public void delete(Object a) {
		
	}
}

