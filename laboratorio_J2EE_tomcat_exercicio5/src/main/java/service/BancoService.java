package service;

import java.util.List;

import dao.BancoDAO;
import model.Banco;

public class BancoService {

	BancoDAO dao = new BancoDAO();

	public void saveBank(Banco banco) {

		dao.inserir(banco);
	}

	public List<Banco> getAllBanks() {
		return dao.getAllBanks();
	}
}
