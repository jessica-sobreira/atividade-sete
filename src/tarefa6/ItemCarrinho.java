package tarefa6;

import java.util.Objects;
import java.math.BigDecimal;

public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Dinheiro calcularSubtotal() {
        return this.produto.getPreco().adicionar(
                new Dinheiro(this.produto.getPreco().getValor().multiply(new BigDecimal(quantidade - 1)), this.produto.getPreco().getMoeda())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrinho that = (ItemCarrinho) o;
        return quantidade == that.quantidade && produto.equals(that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, quantidade);
    }
}