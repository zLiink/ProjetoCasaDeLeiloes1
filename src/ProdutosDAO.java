
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

    public int cadastrarProduto(ProdutosDTO produto) {
        int status = 0;
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES  (?, ?, ?);";

        try {
            conn.conectar();
            st = conn.getConnection().prepareStatement(sql);

            st.setString(1, produto.getNome());
            st.setInt(2, produto.getValor());
            st.setString(3, produto.getStatus());

            status = st.executeUpdate();

            return status = 1;

        } catch (SQLException sqle) {
            sqle.getMessage();
            return status = 0;
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {

        ArrayList<ProdutosDTO> listagem = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        ProdutosDTO produto = new ProdutosDTO();

        try {
            Connection conexao = conn.getConnection();
            st = conexao.prepareStatement(sql);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) {
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setValor(rs.getInt("valor"));
                    produto.setStatus(rs.getString("status"));
                }
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
        }
        return listagem;
    }
}
