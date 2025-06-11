package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class ConnectionFactory {
    
    public static Connection pegarConexao() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","nova_senha_segura");
            System.out.print("conectado com sucesso!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados!\nErro: "+ e);
        }    
        return null;
    }
    public static void fecharConexao(Connection con) {
    try {
        if (con != null) {
            con.close();
        }
    } catch (SQLException e) {
        System.out.println("Erro ao fechar conexão!\nErro: " + e);
    }
}

    public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fecharConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar statement!\nErro: " + e);
        }
    }

}

