package com.alura.jdbc.factory;

import java.sql.*;
import javax.sql.*;

import com.mchange.v2.c3p0.*;
// La clase ConnectionFactory se utilizó para establecer la conexión de la base de datos SQL a JDBC//
public class ConnectionFactory { 
	
	private DataSource datasource;

	public ConnectionFactory() {
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/hotel_alura?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("Mine");
		pooledDataSource.setPassword("Burritos_5fr9t6");
		pooledDataSource.setMaxPoolSize(10);
		this.datasource = pooledDataSource;
		
	}
	public Connection recuperaConexion()  {
		try {
			return this.datasource.getConnection();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}
}
