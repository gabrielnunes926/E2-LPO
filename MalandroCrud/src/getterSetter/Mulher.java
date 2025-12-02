
package getterSetter;
public class Mulher {
    private String cpf;
    private String nome;
    private int telefone;
    private String endereco;

     public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }
    
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

   
    
}
