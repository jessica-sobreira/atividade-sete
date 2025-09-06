package tarefa8;

import java.math.BigDecimal;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        String cep = "12345678";
        BigDecimal peso = new BigDecimal("10.0");

        System.out.println("--- Demonstrando o Padrão Strategy ---");

        Pedido pedido = new Pedido(cep, peso, new FretePac());
        System.out.println("Cálculo com PAC: R$ " + pedido.calcularValorFrete());


        pedido.setCalculadoraFrete(new FreteSedex());
        System.out.println("Cálculo com SEDEX: R$ " + pedido.calcularValorFrete());


        pedido.setCalculadoraFrete(new FreteRetirada());
        System.out.println("Cálculo com Retirada na Loja: R$ " + pedido.calcularValorFrete());

        System.out.println("\n--- Usando uma Lambda para Estratégia Promocional ---");


        BigDecimal valorLimite = new BigDecimal("500.0");


        CalculadoraFrete freteGratisStrategy = (cepDestino, pesoTotal) -> {
            if (pesoTotal.compareTo(valorLimite) > 0) {
                System.out.println("Peso total acima de R$ " + valorLimite + ", frete grátis!");
                return BigDecimal.ZERO;
            } else {

                System.out.println("Peso abaixo do limite, aplicando frete padrão (PAC).");
                return new FretePac().calcular(cepDestino, pesoTotal);
            }
        };


        pedido.setCalculadoraFrete(freteGratisStrategy);
        BigDecimal pesoBaixo = new BigDecimal("200.0");
        System.out.println("Frete para peso " + pesoBaixo + ": R$ " + new Pedido(cep, pesoBaixo, freteGratisStrategy).calcularValorFrete());


        BigDecimal pesoAlto = new BigDecimal("600.0");
        System.out.println("Frete para peso " + pesoAlto + ": R$ " + new Pedido(cep, pesoAlto, freteGratisStrategy).calcularValorFrete());

        System.out.println("\n--- Testando validação de CEP ---");
        try {
            Pedido pedidoInvalido = new Pedido("123", new BigDecimal("10.0"), new FreteSedex());
            pedidoInvalido.calcularValorFrete();
        } catch (CepInvalidoException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}