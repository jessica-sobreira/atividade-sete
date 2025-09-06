package tarefa3;

import java.math.BigDecimal;

public class Funcionario {
    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario) {
        if (salario == null || salario.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O salário não pode ser nulo ou negativo.");
        }
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public BigDecimal calcularBonus() {
        return BigDecimal.ZERO;
    }
}