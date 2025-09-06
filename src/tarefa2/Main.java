package tarefa2;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Exercício 2: Aplicando Desconto ---");

        Produto produto1 = new Produto("Cadeira", 200.00, 50);
        System.out.println("Preço original: " + produto1);

        try {
            System.out.println("Aplicando desconto de 20%...");
            produto1.aplicarDesconto(20);
            System.out.println("Preço com desconto: " + produto1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }

        System.out.println("\n--- Testando desconto inválido ---");

        try {
            System.out.println("Tentando aplicar desconto de 60%...");
            produto1.aplicarDesconto(60);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        try {
            System.out.println("Tentando aplicar desconto de -10%...");
            produto1.aplicarDesconto(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}