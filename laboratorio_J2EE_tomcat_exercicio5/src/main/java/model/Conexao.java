package model;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Conexao {

	public static Connection getConnection() {

		try {
			var initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/lab3");
			return ds.getConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na conexão com banco de dados!" + e.getMessage());
		}
	}

}
