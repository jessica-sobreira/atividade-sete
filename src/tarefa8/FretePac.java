package tarefa8;

import java.math.BigDecimal;

public class FretePac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(String cepDestino, BigDecimal pesoTotal) {
        if (cepDestino == null || cepDestino.length() != 8) {
            throw new CepInvalidoException("CEP inválido para PAC.");
        }
        return new BigDecimal("15.00").add(pesoTotal.multiply(new BigDecimal("0.75")));
    }
}