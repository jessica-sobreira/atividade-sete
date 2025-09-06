package tarefa1;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testando atribuições válidas ---");
        try {
            Produto produto1 = new Produto("TV", 7800.00, 200);
            System.out.println("Produto criado com sucesso: " + produto1);

            produto1.setPreco(3200.00);
            produto1.setQuantidadeEmEstoque(8);
            System.out.println("Valores alterados com sucesso: " + produto1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("\n--- Testando atribuições inválidas ---");

        try {
            new Produto(null, 100.00, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste de nome nulo: Erro esperado -> " + e.getMessage());
        }


        try {
            new Produto("Garrafa de água", -50.00, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste de preço negativo: Erro esperado -> " + e.getMessage());
        }

        try {
            Produto produto2 = new Produto("Ventilador", 150.00, 50);
            System.out.println("\nProduto criado para teste: " + produto2);
            produto2.setQuantidadeEmEstoque(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Teste de quantidade negativa: Erro esperado -> " + e.getMessage());
        }
    }
}