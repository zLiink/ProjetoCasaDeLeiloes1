
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
     Connection conn;

    public boolean conectar() {

        String url = "jdbc:mysql://localhost:3306/sistemaleilao"; //Nome da base de dados
        String user = "root"; //nome do usuário do MySQL
        String password = "123456"; //senha do MySQL

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso");

            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Falha na conexão com o banco" + " " + ex.getMessage());
            return false;
        }

    }
    
    //pegar a conexao
    public Connection getConnection() {
        if(conn == null){
            conectar();
        }
        return conn;
    }

    public void desconectar() {

        try {
            conn.close();
        } catch (SQLException sqle) {

        }

    }
    
}
