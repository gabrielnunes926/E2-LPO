
package main;

import dao.MalandroDAO;
import java.sql.SQLException;
import malandro.Malandro;

public class MalandroMain {
    public static void main(String[] args) throws SQLException {
        MalandroDAO dao = new MalandroDAO();

        // Inserir novo cliente
        Malandro m1 = new Malandro();
        m1.setEstilo("Jogador");
        m1.setPenteado("Escovinha");
        m1.setTelefone("11987654321");
        dao.inserir(m1);

        // Listar clientes
        for (Malandro m : dao.listar()) {
            System.out.println(m.getCpf() + " - " + m.getEstilo() + " - " + m.getPenteado());
        }

        // Atualizar
        m1.setCpf("1"); // exemplo
        m1.setEstilo("João Atualizado");
        dao.atualizar(m1);

        // Deletar
        dao.deletar("1");
    }
    
}
