package bean;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Banco;
import model.Conexao;

public class BancoBean {

    Connection conn = Conexao.getConnection();
    
    public void inserir(Banco banco) {
        try  {
            String sql = "INSERT INTO banco (identificador, nome, data_nascimento) VALUES (?, ?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, banco.getIdentificador());
            stmt.setString(2, banco.getNome());
            stmt.setDate(3, java.sql.Date.valueOf(banco.getData_nascimento()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Banco> listarTodos() {
    	
        List<Banco> lista = new ArrayList<>();
        
        try {
        
            String sql = "SELECT * FROM banco";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Banco banco = new Banco();
                banco.setIdBanco(rs.getInt("id_banco")); 
                banco.setIdentificador(rs.getString("identificador"));
                banco.setNome(rs.getString("nome"));
                banco.setData_nascimento(rs.getDate("data_nascimento").toLocalDate());
                lista.add(banco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
