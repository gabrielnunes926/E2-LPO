
package dao;

import malandro.Malandro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MalandroDAO {

   
    // create
    public void inserir(Malandro malandro) throws SQLException {
        String sql = "INSERT INTO malandro (cpf, estilo, penteado, telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, malandro.getCpf());
            stmt.setString(2, malandro.getEstilo());
            stmt.setString(3, malandro.getPenteado());
            stmt.setString(4, malandro.getTelefone());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Malandro cadastrado com sucesso!");

        }
    }
    
    
    // read
    public List<Malandro> listar() {
        List<Malandro> malandro = new ArrayList<>();
        String sql = "SELECT * FROM malandro";

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Malandro m = new Malandro();
                m.setCpf(rs.getString("cpf"));
                m.setEstilo(rs.getString("estilo"));
                m.setPenteado(rs.getString("penteado"));
                m.setTelefone(rs.getString("telefone"));
                malandro.add(m);
            }
            } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return malandro;
    }
    
    
    // update
     public void atualizar(Malandro malandro) {
         
         
        String sql = "UPDATE malandro SET estilo=?, penteado=?, telefone=? WHERE cpf=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, malandro.getEstilo());
            stmt.setString(2, malandro.getPenteado());
            stmt.setString(3, malandro.getTelefone());
            stmt.setString(4, malandro.getCpf());
            stmt.executeUpdate();

            System.out.println("Malandro atualizado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        }
    }
     
     
     // delete
       public void deletar(String cpf) {
        String sql = "DELETE FROM malandro WHERE cpf=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

            System.out.println("Malandro excluído com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}
