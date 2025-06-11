/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Quarto;

/**
 *
 * @author rebek
 */
public class QuartoDAO {
    public void criarRegistroNoBancodeDados(Quarto q)throws SQLException{
        Connection con = ConnectionFactory.pegarConexao();
        PreparedStatement stmt = null;
        String sql = "insert into quartos (numero, tipo, status, valor) values (?,?,?,?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, q.getNumero());
            stmt.setString(2, q.getTipo());
            stmt.setString(3, q.getStatus());
            stmt.setString(4, q.getValor());
            
            stmt.executeUpdate();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados"+ e.toString());
        }finally{
            ConnectionFactory.fecharConexao(con, stmt);
        }
    }
    
    public List<String> listarQuartos() {
        List<String> quartos = new ArrayList<>();
        System.out.println(quartos);
        String sql = "SELECT numero FROM quartos"; 

        try (Connection con = ConnectionFactory.pegarConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                quartos.add(rs.getString("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quartos;
    }
    
}
