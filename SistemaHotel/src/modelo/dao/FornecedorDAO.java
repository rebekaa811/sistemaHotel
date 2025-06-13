package modelo.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor; 

public class FornecedorDAO {

    public List<Fornecedor> listarTodos() {
        List<Fornecedor> lista = new ArrayList<>();
        String sql = "SELECT id, nome FROM fornecedor ORDER BY nome";

        try (Connection con = ConnectionFactory.pegarConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fornecedor f = new Fornecedor(); 
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                lista.add(f);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    public Fornecedor buscarPorNome(String nome) {
    Fornecedor fornecedor = null;
    String sql = "SELECT id, nome FROM fornecedor WHERE nome = ? LIMIT 1";

    try (Connection con = ConnectionFactory.pegarConexao();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, nome);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setNome(rs.getString("nome"));
        }

        rs.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return fornecedor;
}

}
