package tarefa8;

import java.math.BigDecimal;

public class FreteSedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(String cepDestino, BigDecimal pesoTotal) {
        if (cepDestino == null || cepDestino.length() != 8) {
            throw new CepInvalidoException("CEP inválido para Sedex.");
        }
        return new BigDecimal("25.50").add(pesoTotal.multiply(new BigDecimal("1.50")));
    }
}