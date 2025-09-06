package tarefa6;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Produto teclado = new Produto("Teclado Mecânico", new Dinheiro(new BigDecimal("350.50"), Moeda.BRL));
        Produto mouse = new Produto("Mouse Gamer", new Dinheiro(new BigDecimal("180.00"), Moeda.BRL));

        Carrinho carrinho1 = new Carrinho();
        System.out.println("Carrinho inicial: " + carrinho1);

        Carrinho carrinho2 = carrinho1.adicionarItem(new ItemCarrinho(teclado, 1));
        Carrinho carrinho3 = carrinho2.adicionarItem(new ItemCarrinho(mouse, 2));
        System.out.println("Carrinho após adicionar itens: " + carrinho3);
        System.out.println("Total: " + carrinho3.calcularTotal());


        Carrinho carrinho4 = carrinho3.aplicarCupom(new BigDecimal("0.15"));
        System.out.println("Carrinho após cupom: " + carrinho4);
        System.out.println("Total com desconto: " + carrinho4.calcularTotal());


        Carrinho carrinho5 = carrinho4.removerItem(new ItemCarrinho(teclado, 1));
        System.out.println("Carrinho após remover um item: " + carrinho5);
        System.out.println("Total após remoção: " + carrinho5.calcularTotal());


        System.out.println("\n--- Testando operações inválidas ---");
        try {
            new ItemCarrinho(teclado, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            carrinho5.aplicarCupom(new BigDecimal("0.35"));
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}