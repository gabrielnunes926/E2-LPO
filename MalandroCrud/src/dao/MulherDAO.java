
package dao;

import getterSetter.Mulher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MulherDAO {
     // create
    public void inserir(Mulher mulher) throws SQLException {
        String sql = "INSERT INTO mulher (cpf, nome, telefone, endereco) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, mulher.getCpf());
            stmt.setString(2, mulher.getNome());
            stmt.setInt(3, mulher.getTelefone());
            stmt.setString(4, mulher.getEndereco());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Mulher cadastrada com sucesso!");

        }
    }
    
    
    // read
    public List<Mulher> listar() {
        List<Mulher> mulher = new ArrayList<>();
        String sql = "SELECT * FROM mulher";

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mulher mu = new Mulher();
                mu.setCpf(rs.getString("cpf"));
                mu.setNome(rs.getString("nome"));
                mu.setTelefone(Integer.parseInt(rs.getString("telefone")));
                mu.setEndereco(rs.getString("endereco"));
                mulher.add(mu);
            }
            } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return mulher;
    }
    
    
    // update
    public void atualizar(Mulher mulher) {

    String sql = "UPDATE mulher SET nome=?, telefone=?, endereco=? WHERE cpf=?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, mulher.getNome());
        stmt.setInt(2, mulher.getTelefone());
        stmt.setString(3, mulher.getEndereco());
        stmt.setString(4, mulher.getCpf());
        
        

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas == 0) {
            
            JOptionPane.showMessageDialog(
                null,
                "Nenhuma mulher encontrada com o Cpf: " + mulher.getCpf(),
                "Cpf inexistente",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(null, "Mulher atualizada com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao atualizar: " + e.getMessage());
    }
}

     
     // delete
       public void deletar(String cpf) {
        String sql = "DELETE FROM mulher WHERE cpf=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

            System.out.println("Mulher excluida com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}


