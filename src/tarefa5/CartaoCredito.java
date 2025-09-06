package tarefa5;

import java.math.BigDecimal;

public class CartaoCredito extends FormaPagamento {
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (numeroCartao == null || numeroCartao.length() != 16 || !numeroCartao.matches("\\d+")) {
            throw new PagamentoInvalidoException("Número do cartão de crédito inválido.");
        }
        System.out.println("Cartão de crédito validado com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Processando pagamento de R$ " + valor + " com Cartão de Crédito.");
        System.out.println("Pagamento com Cartão de Crédito realizado com sucesso!");
    }
}