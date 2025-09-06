package tarefa4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IMeioTransporte> veiculos = new ArrayList<>();
        veiculos.add(new Carro());
        veiculos.add(new Bicicleta());
        veiculos.add(new Trem());

        System.out.println("--- Demonstrando o Polimorfismo ---");

        for (IMeioTransporte veiculo : veiculos) {
            System.out.println("\n--- Acelerando um veículo ---");
            try {
                veiculo.acelerar(30);
                veiculo.acelerar(15);
            } catch (IllegalStateException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("\n--- Freando todos os veículos ---");
        for (IMeioTransporte veiculo : veiculos) {
            veiculo.frear(20);
        }

        System.out.println("\n--- Testando operações inválidas (Exceções) ---");
        Carro carroDeTeste = new Carro();
        try {
            System.out.println("\nTentando acelerar um Carro acima do limite...");
            carroDeTeste.acelerar(250);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        Bicicleta bicicletaDeTeste = new Bicicleta();
        try {
            System.out.println("\nTentando frear a Bicicleta com valor negativo...");
            bicicletaDeTeste.frear(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}