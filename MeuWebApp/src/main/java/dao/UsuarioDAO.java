package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Conexao;
import model.Usuario;

public class UsuarioDAO {

	Connection conn = Conexao.getConnection();

	public void inserir(Usuario usuario) {

		String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());

			stmt.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir no banco, " + e.getMessage());
		}

	}

	public List<Usuario> getAllUsers() {

		List<Usuario> usuariosList = new ArrayList<>();
		String sql = "SELECT * FROM usuario";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Usuario u = new Usuario();
				u.setId(rs.getInt("idUsuario"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				usuariosList.add(u);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao listar usuários", e);
		}
		return usuariosList;
	}

	public boolean deleteByID(int id) {

		String sql = "DELETE FROM usuario WHERE idUsuario = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas > 0;

		} catch (Exception e) {
			throw new RuntimeException("Erro ao deletar usuário" + e.getMessage());
		}
	}

	public Usuario findById(int id) {

		String sql = "SELECT * FROM usuario WHERE idUsuario = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			Usuario u = new Usuario();

			while (rs.next()) {
				u.setId(rs.getInt("idUsuario"));
				u.setEmail(rs.getString("email"));
				u.setNome(rs.getString("nome"));
			}
			return u;
		} catch (Exception e) {
			throw new RuntimeException("Usuário não encontrado!" + e.getMessage());
		}
	}

	public int updateUser(Usuario user) {

		String sql = "UPDATE usuario set nome = ?, email = ? WHERE idUsuario = ?";

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setInt(3, user.getId());

			int linhasAfetadas = stmt.executeUpdate();
			return linhasAfetadas;

		} catch (Exception e) {
			throw new RuntimeException("Erro ao atualizar usuário" + e.getMessage());
		}

	}
}
