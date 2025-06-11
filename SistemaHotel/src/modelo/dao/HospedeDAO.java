/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;
import conexao.ConnectionFactory;
import model.Hospede;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author rebek
 */
public class HospedeDAO {
    
    public void criarRegistroNoBancodeDados(Hospede h)throws SQLException{
        Connection con = ConnectionFactory.pegarConexao();
        PreparedStatement stmt = null;
        String sql = "insert into hospedes (nome, cpf, dataNasc, celular, email) values (?,?,?,?,?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, h.getNome());
            stmt.setString(2, h.getCpf());
            stmt.setDate(3, java.sql.Date.valueOf(h.getDataNasc()));
            stmt.setString(4, h.getCelular());
            stmt.setString(5, h.getEmail());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados"+ e.toString());
        }finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    public List<String> listarHospedes() {
        List<String> hospedes = new ArrayList<>();
        String sql = "SELECT nome FROM hospedes"; // Ajuste o nome da tabela e campo conforme seu BD

        try (Connection con = ConnectionFactory.pegarConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                hospedes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospedes;
    }
    
}
    
