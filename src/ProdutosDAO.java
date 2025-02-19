
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.SQLException;

public class ProdutosDAO {

    Connection conexao;
    PreparedStatement st;
    ResultSet rs = null;
    conectaDAO conn = new conectaDAO();

        String sql = "INSERT INTO produtos (nome, valor, status) VALUES  (?, ?, ?);";

    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public int cadastrarProduto(ProdutosDTO produto) {
        int status = 0;

        try {
            conn.conectar();
            st = conn.getConnection().prepareStatement(sql);

            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());
            st.setString(3, produto.getStatus());

            status = st.executeUpdate();
            conn.desconectar();

            return status = 1;

        } catch (SQLException sqle) {
            sqle.getMessage();
            return status = 0;
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        return listagem;
    }

}
