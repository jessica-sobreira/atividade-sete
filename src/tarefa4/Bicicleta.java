package tarefa4;

public class Bicicleta implements IMeioTransporte {
    private int velocidadeAtual;
    private final int velocidadeMaxima = 40;

    @Override
    public void acelerar(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("A velocidade de aceleração não pode ser negativa.");
        }
        int novaVelocidade = this.velocidadeAtual + velocidade;
        if (novaVelocidade > velocidadeMaxima) {
            throw new IllegalStateException("Limite de velocidade da Bicicleta (" + velocidadeMaxima + " km/h) excedido!");
        }
        this.velocidadeAtual = novaVelocidade;
        System.out.println("Bicicleta acelerando. Velocidade atual: " + this.velocidadeAtual + " km/h.");
    }

    @Override
    public void frear(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("A velocidade de desaceleração não pode ser negativa.");
        }
        int novaVelocidade = this.velocidadeAtual - velocidade;
        if (novaVelocidade < 0) {
            this.velocidadeAtual = 0;
            System.out.println("Bicicleta freando. Parou completamente. Velocidade atual: 0 km/h.");
        } else {
            this.velocidadeAtual = novaVelocidade;
            System.out.println("Bicicleta freando. Velocidade atual: " + this.velocidadeAtual + " km/h.");
        }
    }
}