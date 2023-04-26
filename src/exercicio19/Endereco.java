package exercicio19;

public class Endereco {
    private String rua;
    private int numero;
    private String cidade;
    private String estado;
    private String bairro;

    public Endereco(String rua, int numero, String cidade, String estado, String bairro) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
    }
    public String getRua() {
        return rua;
    }
    public int getNumero() {
        return numero;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getBairro(){
        return bairro;
    }

    //setters
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    @Override
    public String toString() {
        return rua + ", " + numero + " - " + bairro + " - " + cidade + " - " + estado + ".";
    }
}
