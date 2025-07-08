package service;

import java.util.List;

import dao.BancoDAO;
import model.Banco;

public class BancoService {

	BancoDAO dao = new BancoDAO();

	public void saveBank(Banco banco) {
		dao.saveBank(banco);
	}

	public List<Banco> getAllBanks() {
		return dao.getAllBanks();
	}

	public Banco getOneBank(int id) {
		return dao.findById(id);
	}

	public void updateById(Banco banco) {
		dao.updateById(banco);
	}

	public boolean deleteById(int id) {
		dao.deleteById(id);
		return true;
	}
}
