package exercicio20;

import java.math.BigDecimal;

public class Produto {
    private int id;
    private String nome;
    private BigDecimal preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, BigDecimal preco, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id =" + id +
                ", nome ='" + nome + '\'' +
                ", preço =" + preco +
                ", quantidadeEmEstoque =" + quantidadeEmEstoque +
                '}';
    }
}
