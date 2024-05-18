package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public static Connection getConnection() throws Exception{
		
		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/bd_apiClientes";
		String user = "postgres";
		String password = "fssrj";
		
		Class.forName(driver);
				
		return DriverManager.getConnection(url, user, password);
		
	}

}
