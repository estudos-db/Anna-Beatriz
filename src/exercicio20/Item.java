package exercicio20;

import java.math.BigDecimal;

public class Item {
    private Produto produto;
    private int quantidade;
    private BigDecimal valorDoItem;

    public Item(Produto produto, BigDecimal precoProduto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorDoItem = precoProduto.multiply(BigDecimal.valueOf(quantidade));
    }

    public Produto getProduto() {
        return produto;
    }
    public String getNomeProduto() {
        return produto.getNomeProduto();
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

    public BigDecimal getValorDoItem() {
        return valorDoItem;
    }

    public void setValorDoItem(BigDecimal valorDoItem) {
        this.valorDoItem = valorDoItem;
    }
    public void defineValorTotal() {
        this.valorDoItem = BigDecimal.valueOf(BigDecimal.valueOf(produto.getPreco()).multiply(BigDecimal.valueOf(quantidade)).doubleValue());
    }
    public CarrinhoItem adicionaAoCarrinho(int quantidade) {
        if (this.quantidade < quantidade) {
            System.out.println("Não há quantidade suficiente no estoque.");
            return null;
        }
        this.quantidade -= quantidade;
        return new CarrinhoItem(this, quantidade);
    }
}
class CarrinhoItem {
    private Item item;
    private int quantidade;

    public CarrinhoItem(Produto item, int quantidade) {
        this.item = item;
        this.quantidade = quantidade;
    }
    public Item getItem() {
        return item;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public BigDecimal getPrecoTotal() {
        BigDecimal quantidadeBigDecimal = BigDecimal.valueOf(quantidade);
        return quantidadeBigDecimal.multiply(item.getValorDoItem());
    }
}


