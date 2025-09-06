package tarefa8;

import java.math.BigDecimal;

public class Pedido {
    private final String cepDestino;
    private final BigDecimal pesoTotal;
    private CalculadoraFrete calculadoraFrete;

    public Pedido(String cepDestino, BigDecimal pesoTotal, CalculadoraFrete calculadoraFrete) {
        this.cepDestino = cepDestino;
        this.pesoTotal = pesoTotal;
        this.calculadoraFrete = calculadoraFrete;
    }


    public void setCalculadoraFrete(CalculadoraFrete novaCalculadora) {
        this.calculadoraFrete = novaCalculadora;
    }

    public BigDecimal calcularValorFrete() {
        return calculadoraFrete.calcular(cepDestino, pesoTotal);
    }
}