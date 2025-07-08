package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Banco;

public class BancoDAO {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab7");

	public void saveBank(Banco banco) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(banco);
		em.getTransaction().commit();
		em.close();
	}

	public List<Banco> getAllBanks() {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		List<Banco> bankList = em.createQuery("SELECT b FROM Banco b ", Banco.class).getResultList();
		em.close();

		return bankList;
	}

	public Banco findById(int id) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Banco banco = em.find(Banco.class, id);

		if (banco != null) {
			return banco;
		}

		throw new RuntimeException("Banco não encontrado!");
	}

	public void updateById(Banco banco) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.merge(banco);

		em.getTransaction().commit();

		em.close();
	}

	public boolean deleteById(int id) {

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		Banco banco = em.find(Banco.class, id);

		if (banco != null) {
			em.remove(banco);
			em.getTransaction().commit();
			em.close();
			return true;
		} else {
			return false;
		}

	}

}