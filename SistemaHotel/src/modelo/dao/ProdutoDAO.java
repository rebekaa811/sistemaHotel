package modelo.dao;

import conexao.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Produto;
import java.math.BigDecimal;

public class ProdutoDAO {
    public void criarRegistroNoBancodeDados(Produto p) throws SQLException {
        Connection con = ConnectionFactory.pegarConexao();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO produto (nome, preco, estoque, id_fornecedor) VALUES (?, ?, ?, ?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setBigDecimal(2, p.getPreco());
            stmt.setInt(3, p.getEstoque());
            stmt.setInt(4, p.getId_fornecedor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados: " + e.toString());
        } finally {
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }

    public List<String> listarProdutos() {
        List<String> produtos = new ArrayList<>();
        String sql = "SELECT nome FROM produto";  // verifique o nome correto da tabela

        try (Connection con = ConnectionFactory.pegarConexao();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                produtos.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
