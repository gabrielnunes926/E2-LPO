
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
   private static final String URL = "jdbc:mysql://localhost:3306/malandro_crud";
    private static final String USER = "root";
    private static final String PASSWORD = "Gg_1919@";

    public static Connection getConnection() {
        try {
            // 🔹 Carrega o driver JDBC (IMPORTANTE)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 🔹 Tenta a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
            return null;
            
        } catch (SQLException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
    
}
