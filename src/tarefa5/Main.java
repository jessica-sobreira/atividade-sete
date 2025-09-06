package tarefa5;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BigDecimal valorPagamento = new BigDecimal("150.75");

        List<FormaPagamento> pagamentos = new ArrayList<>();
        pagamentos.add(new CartaoCredito("1234567890123456"));
        pagamentos.add(new Boleto("001900000901234567890123456789012345678901234"));
        pagamentos.add(new Pix("teste.teste@teste.com"));
        pagamentos.add(new CartaoCredito("123"));
        pagamentos.add(new Boleto("invalido"));
        pagamentos.add(new Pix(null));

        for (FormaPagamento pagamento : pagamentos) {
            System.out.println("\n--- Processando pagamento ---");
            try {
                pagamento.processarPagamento(valorPagamento);
            } catch (PagamentoInvalidoException e) {
                System.out.println("Falha no pagamento: " + e.getMessage());
            }
        }
    }
}