
package dao;

import getterSetter.Moto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MotoDAO {
     // create
    public void inserir(Moto moto) throws SQLException {
        String sql = "INSERT INTO moto (vin, cor, marca, peso) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, moto.getVin());
            stmt.setString(2, moto.getCor());
            stmt.setString(3, moto.getMarca());
            stmt.setInt(4, moto.getPeso());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Moto cadastrada com sucesso!");

        }
    }
    
    
    // read
    public List<Moto> listar() {
        List<Moto> moto = new ArrayList<>();
        String sql = "SELECT * FROM moto";

        try (Connection conn = Conexao.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Moto mo = new Moto();
                mo.setVin(Integer.parseInt(rs.getString("vin")));
                mo.setCor(rs.getString("cor"));
                mo.setMarca(rs.getString("marca"));
                mo.setPeso(Integer.parseInt(rs.getString("peso")));
                moto.add(mo);
            }
            } catch (Exception e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return moto;
    }
    
    
    // update
    public void atualizar(Moto moto) {

    String sql = "UPDATE moto SET cor=?, marca=?, peso=? WHERE vin=?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, moto.getCor());
        stmt.setString(2, moto.getMarca());
        stmt.setInt(3, moto.getPeso());
        stmt.setInt(4, moto.getVin());

        int linhasAfetadas = stmt.executeUpdate();

        if (linhasAfetadas == 0) {
            
            JOptionPane.showMessageDialog(
                null,
                "Nenhuma moto encontrada com o VIN: " + moto.getVin(),
                "VIN inexistente",
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(null, "Moto atualizada com sucesso!");

    } catch (Exception e) {
        System.out.println("Erro ao atualizar: " + e.getMessage());
    }
}

     
     // delete
       public void deletar(int vin) {
        String sql = "DELETE FROM moto WHERE vin=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vin);
            stmt.executeUpdate();

            System.out.println("Moto excluida com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        }
    }
}


