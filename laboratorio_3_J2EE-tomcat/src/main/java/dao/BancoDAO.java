package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Banco;
import model.Conexao;

public class BancoDAO {

	Connection conn = Conexao.getConnection();

	public void inserir(Banco banco) {

		String sql = "INSERT INTO banco(identificador, nome, data_nascimento) VALUES (?, ?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, banco.getIdentificador());
			stmt.setString(2, banco.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(banco.getData_nascimento()));

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir no banco" + e.getMessage());
		}
	}

	public List<Banco> getAllBanks() {

		System.out.print("Dao chamada");
		List<Banco> banksList = new ArrayList();
		String sql = "SELECT * FROM banco";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Banco b = new Banco();
				System.out.println(rs.getDate("data_nascimento").toLocalDate());
				b.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
				b.setId_banco(rs.getInt("id_banco"));
				b.setIdentificador(rs.getString("identificador"));
				b.setNome(rs.getString("nome"));
				banksList.add(b);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao capturar dados do banco" + e.getMessage());
		}
		return banksList;
	}

	public boolean deleteById(int id) {

		String sql = "DELETE FROM banco where id_banco = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			int linhasAfetadas = stmt.executeUpdate();

			return linhasAfetadas > 0;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar dados do banco" + e.getMessage());
		}
	}

	public int updateById(int id, Banco banco) {

		String sql = "UPDATE banco SET identificador = ?, nome = ?, data_nascimento = ? WHERE id_banco = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, banco.getIdentificador());
			stmt.setString(2, banco.getNome());
			stmt.setDate(3, Date.valueOf(banco.getData_nascimento()));
			stmt.setInt(4, id);
			
			int linhasAfetadas = stmt.executeUpdate();
			
			return linhasAfetadas;
		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar dados do banco" + e.getMessage());
		}
	}

}
