package tarefa6;

import java.util.Objects;

public final class Produto {
    private final String nome;
    private final Dinheiro preco;

    public Produto(String nome, Dinheiro preco) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser nulo ou vazio.");
        }
        if (preco == null) {
            throw new IllegalArgumentException("O preço do produto não pode ser nulo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public Dinheiro getPreco() {
        return preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return nome.equals(produto.nome) && preco.equals(produto.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, preco);
    }
}