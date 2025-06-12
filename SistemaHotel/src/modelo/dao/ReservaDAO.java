/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Reserva;


/**
 *
 * @author rebek
 */
public class ReservaDAO {
    public void salvar(Reserva reserva) throws SQLException {
        Connection con = ConnectionFactory.pegarConexao();
        String sql = "INSERT INTO reservas (data_entrada, data_saida, status, hospede_id, quarto_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(reserva.getDataEntrada()));
            stmt.setDate(2, java.sql.Date.valueOf(reserva.getDataSaida()));
            stmt.setString(3, reserva.getStatus());
            stmt.setInt(4, reserva.getHospedeId());
            stmt.setInt(5, reserva.getQuartoId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar reserva: " + e);
        }
    }
    public List<Reserva> buscarReservas(String nome, String cpf) {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT r.id, h.nome, h.cpf, q.numero, r.data_entrada, r.data_saida, r.status, q.valor "
                   + "FROM reservas r "
                   + "JOIN hospedes h ON r.hospede_id = h.id "
                   + "JOIN quartos q ON r.quarto_id = q.id "
                   + "WHERE h.nome LIKE ? AND h.cpf LIKE ?";

        try (Connection con = ConnectionFactory.pegarConexao();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome + "%");
            stmt.setString(2, "%" + cpf + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId(rs.getInt("id"));
                r.setNomeHospede(rs.getString("nome"));
                r.setCpfHospede(rs.getString("cpf"));
                r.setNumeroQuarto(rs.getString("numero"));
                r.setDataEntrada(rs.getDate("data_entrada").toLocalDate());
                r.setDataSaida(rs.getDate("data_saida").toLocalDate());
                r.setValor(rs.getString("valor"));
                r.setStatus(rs.getString("status"));
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
   }
    
   public void excluir(int idReserva) throws SQLException {
    Connection con = ConnectionFactory.pegarConexao();
    String sql = "DELETE FROM reservas WHERE id = ?";

    try (PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, idReserva);
        stmt.executeUpdate();
    }
   }
   
   public int buscarIdHospedePorNome(String nome) {
    int id = -1;
    String sql = "SELECT id FROM hospedes WHERE nome = ?";

    try (Connection con = ConnectionFactory.pegarConexao();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        } else {
            JOptionPane.showMessageDialog(null, "Hóspede não encontrado: " + nome);
        }
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar ID do hóspede: " + e.getMessage());
    }
    return id;
}
   public int buscarIdQuartoPorNumero(String numero) {
    int id = -1;
    String sql = "SELECT id FROM quartos WHERE numero = ?";

    try (Connection con = ConnectionFactory.pegarConexao();
         PreparedStatement stmt = con.prepareStatement(sql)) {

        stmt.setString(1, numero);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            id = rs.getInt("id");
        } else {
            JOptionPane.showMessageDialog(null, "Quarto não encontrado: " + numero);
        }

        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao buscar ID do quarto: " + e.getMessage());
    }

    return id;
}

    
}
