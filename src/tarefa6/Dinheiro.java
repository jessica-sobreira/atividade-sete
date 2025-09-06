package tarefa6;

import java.math.BigDecimal;
import java.util.Objects;
import java.math.RoundingMode;

public final class Dinheiro {
    private final BigDecimal valor;
    private final Moeda moeda;

    public Dinheiro(BigDecimal valor, Moeda moeda) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor do dinheiro não pode ser nulo ou negativo.");
        }
        if (moeda == null) {
            throw new IllegalArgumentException("A moeda não pode ser nula.");
        }
        this.valor = valor.setScale(2, RoundingMode.HALF_UP);
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Moeda getMoeda() {
        return moeda;
    }

    public Dinheiro adicionar(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda)) {
            throw new IllegalArgumentException("Não é possível somar moedas diferentes.");
        }
        return new Dinheiro(this.valor.add(outro.valor), this.moeda);
    }

    public Dinheiro subtrair(Dinheiro outro) {
        if (!this.moeda.equals(outro.moeda)) {
            throw new IllegalArgumentException("Não é possível subtrair moedas diferentes.");
        }
        return new Dinheiro(this.valor.subtract(outro.valor), this.moeda);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dinheiro dinheiro = (Dinheiro) o;
        return valor.equals(dinheiro.valor) && moeda == dinheiro.moeda;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, moeda);
    }

    @Override
    public String toString() {
        return moeda.toString() + " " + valor;
    }
}