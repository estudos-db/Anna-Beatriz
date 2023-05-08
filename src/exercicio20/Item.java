package exercicio20;

import java.math.BigDecimal;

public class Item {
    private Produto produto;
    private int quantidade;
    private BigDecimal valorDoItem;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        valorDoItem = produto.getPreco().multiply(BigDecimal.valueOf(quantidade));
    }

    public BigDecimal getValorDoItem() {
        return valorDoItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", valorDoItem=" + valorDoItem +
                '}';
    }
}
