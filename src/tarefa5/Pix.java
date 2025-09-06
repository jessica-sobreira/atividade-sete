package tarefa5;

import java.math.BigDecimal;

public class Pix extends FormaPagamento {
    private String chavePix;

    public Pix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public void validarPagamento() throws PagamentoInvalidoException {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
        System.out.println("Chave Pix validada com sucesso.");
    }

    @Override
    public void processarPagamento(BigDecimal valor) throws PagamentoInvalidoException {
        validarPagamento();
        System.out.println("Transferindo R$ " + valor + " via Pix para a chave " + chavePix + ".");
        System.out.println("Pagamento com Pix realizado com sucesso!");
    }
}