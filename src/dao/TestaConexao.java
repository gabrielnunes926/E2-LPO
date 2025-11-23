
package dao;
public class TestaConexao {
      public static void main(String[] args) {
        var conn = Conexao.getConnection();
        if (conn != null) {
            System.out.println("Conexão realizada com sucesso!");
        } else {
            System.out.println("Falha na conexão!");
        }
    }
}
