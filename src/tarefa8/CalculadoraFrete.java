package tarefa8;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculadoraFrete {
    BigDecimal calcular(String cepDestino, BigDecimal pesoTotal);
}