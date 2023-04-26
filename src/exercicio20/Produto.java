package exercicio20;

import java.math.BigDecimal;

public class Produto {
    private final int id;
    private final String nome;
    private final BigDecimal preco;
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

    public BigDecimal getPreco() {
        return preco;
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
                ", preco =" + preco +
                ", quantidadeEmEstoque =" + quantidadeEmEstoque +
                '}';
    }
}
