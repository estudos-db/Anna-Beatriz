package exercicio19;

public class Contato {
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private Endereco endereco;

    public Contato(String nome, String sobrenome, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    public Endereco getEndereco() {
        return endereco;
    }

    //setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome + " - " + email + " - " + telefone + " - " + endereco;
    }
}
