package getterSetter;
public class Moto {
    
    private int vin;
    private String cor;
    private String marca;
    private int peso;
    
    public int getVin(){
        return vin;
    }
    
    public String getCor(){
        return cor;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public int getPeso(){
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
   

    public void setVin(int vin) {
        this.vin = vin;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
}
