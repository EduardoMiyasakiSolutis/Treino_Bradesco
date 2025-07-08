package model;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Conexao {

	public static EntityManagerFactory getConnection() {

		try {
		    return Persistence.createEntityManagerFactory("lab7");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro na conexão com banco de dados!" + e.getMessage());
		}
	}

}
