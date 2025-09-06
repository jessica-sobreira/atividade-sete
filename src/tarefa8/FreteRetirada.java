package tarefa8;

import java.math.BigDecimal;

public class FreteRetirada implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(String cepDestino, BigDecimal pesoTotal) {
        return BigDecimal.ZERO;
    }
}