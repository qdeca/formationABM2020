package fr.abm.quiz_manager.dataservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.abm.quiz_manager.utils.Configuration;

public abstract class AbstractDAO<T> {

	private Configuration configuration = Configuration.getInstance();
	
	protected Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(configuration.getPropertyValue("db_url"), 
												configuration.getPropertyValue("db_username"), 
												configuration.getPropertyValue("db_password"));
		return conn;
	}
	
	public abstract void create(T entity);
	
	public abstract void update(T entity);
	
	public abstract void delete(T entity);

}
