package tarefa6;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;
    private final BigDecimal descontoPorcentagem;
    private static final BigDecimal MAX_DESCONTO = new BigDecimal("0.30");

    public Carrinho() {
        this.itens = Collections.emptyList();
        this.descontoPorcentagem = BigDecimal.ZERO;
    }

    private Carrinho(List<ItemCarrinho> itens, BigDecimal descontoPorcentagem) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
        this.descontoPorcentagem = descontoPorcentagem;
    }

    public Carrinho adicionarItem(ItemCarrinho item) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.add(item);
        return new Carrinho(novosItens, this.descontoPorcentagem);
    }

    public Carrinho removerItem(ItemCarrinho item) {
        List<ItemCarrinho> novosItens = new ArrayList<>(this.itens);
        novosItens.remove(item);
        return new Carrinho(novosItens, this.descontoPorcentagem);
    }

    public Carrinho aplicarCupom(BigDecimal porcentagem) {
        if (porcentagem == null || porcentagem.compareTo(BigDecimal.ZERO) < 0 || porcentagem.compareTo(MAX_DESCONTO) > 0) {
            throw new IllegalArgumentException("Porcentagem de cupom inválida. Deve ser entre 0 e 30%.");
        }
        return new Carrinho(this.itens, porcentagem);
    }

    public Dinheiro calcularTotal() {
        Dinheiro total = new Dinheiro(BigDecimal.ZERO, Moeda.BRL);
        if (this.itens.isEmpty()) {
            return total;
        }

        for (ItemCarrinho item : this.itens) {
            total = total.adicionar(item.calcularSubtotal());
        }

        if (this.descontoPorcentagem.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal valorDesconto = total.getValor().multiply(this.descontoPorcentagem).setScale(2, RoundingMode.HALF_UP);
            total = total.subtrair(new Dinheiro(valorDesconto, total.getMoeda()));
        }
        return total;
    }

    public List<ItemCarrinho> getItens() {
        return this.itens;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "itens=" + itens.size() +
                ", total=" + calcularTotal() +
                '}';
    }
}