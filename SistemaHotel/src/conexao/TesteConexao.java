/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;

public class TesteConexao {
    
    public static void main(String[] args) {
        Connection con = ConnectionFactory.pegarConexao();
        if (con != null) {
            System.out.println("Conexão OK!");
            ConnectionFactory.fecharConexao(con);
        } else {
            System.out.println("Falha na conexão.");
        }
    }
    
}
