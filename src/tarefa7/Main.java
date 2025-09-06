package tarefa7;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
         IRepository<Produto, Integer> repoProduto = new InMemoryRepository<>();

        System.out.println("--- Testando Repositório de Produtos ---");
        repoProduto.salvar(new Produto(1, "Notebook"));
        repoProduto.salvar(new Produto(2, "Smartphone"));

        List<Produto> produtos = repoProduto.listarTodos();
        System.out.println("Lista de produtos: " + produtos);

        Optional<Produto> produtoEncontrado = repoProduto.buscarPorId(1);
        produtoEncontrado.ifPresent(p -> System.out.println("Produto encontrado por ID: " + p));

        try {
            repoProduto.remover(2);
            System.out.println("Produto com ID 2 removido com sucesso.");
            repoProduto.remover(99);
        } catch (EntidadeNaoEncontradaException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
        System.out.println("Lista de produtos após remoção: " + repoProduto.listarTodos());

        System.out.println("\n--- Testando Repositório de Funcionários ---");

        IRepository<Funcionario, String> repoFuncionario = new InMemoryRepository<>();

        repoFuncionario.salvar(new Funcionario("f001", "Maria Silva"));
        repoFuncionario.salvar(new Funcionario("f002", "Jose Lima"));

        Optional<Funcionario> funcionarioEncontrado = repoFuncionario.buscarPorId("f001");
        funcionarioEncontrado.ifPresent(f -> System.out.println("Funcionário encontrado por ID: " + f));

        System.out.println("Lista de funcionários: " + repoFuncionario.listarTodos());
    }
}