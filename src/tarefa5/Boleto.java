package tarefa5;

import java.math.BigDecimal;

public class Boleto extends FormaPagamento {
    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (codigoBarras == null || !codigoBarras.matches("\\d{47}")) {
            throw new PagamentoInvalidoException("Código de barras do boleto inválido.");
        }
        System.out.println("Boleto validado com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Gerando boleto no valor de R$ " + valor + ".");
        System.out.println("Boleto gerado com sucesso! Aguardando pagamento.");
    }
}