package tarefa3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Gerente("Maria Santos", new BigDecimal("8000.00")));
        funcionarios.add(new Desenvolvedor("Lucas Froner", new BigDecimal("5500.00")));
        funcionarios.add(new Gerente("Daniel Silva", new BigDecimal("9500.00")));
        funcionarios.add(new Desenvolvedor("Samuel Rodrigues", new BigDecimal("6000.00")));


        System.out.println("--- Cálculo de Bônus dos Funcionários ---");
        for (Funcionario f : funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("Salário: R$ " + f.getSalario());
            System.out.println("Bônus: R$ " + f.calcularBonus());
            System.out.println("---------------------------------");
        }
    }
}