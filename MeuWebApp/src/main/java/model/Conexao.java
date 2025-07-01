package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/loja",
					"root",
					"01082011Dudu@");
		} catch (Exception e) {
			throw new RuntimeException("Erro na conexão com o banco de dados" + e.getMessage());
		}
	}
}
