package tarefa4;

public class Trem implements IMeioTransporte {
    private int velocidadeAtual;
    private final int velocidadeMaxima = 300;

    @Override
    public void acelerar(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("A velocidade de aceleração não pode ser negativa.");
        }
        int novaVelocidade = this.velocidadeAtual + velocidade;
        if (novaVelocidade > velocidadeMaxima) {
            throw new IllegalStateException("Limite de velocidade do Trem (" + velocidadeMaxima + " km/h) excedido!");
        }
        this.velocidadeAtual = novaVelocidade;
        System.out.println("Trem acelerando. Velocidade atual: " + this.velocidadeAtual + " km/h.");
    }

    @Override
    public void frear(int velocidade) {
        if (velocidade < 0) {
            throw new IllegalArgumentException("A velocidade de desaceleração não pode ser negativa.");
        }
        int novaVelocidade = this.velocidadeAtual - velocidade;
        if (novaVelocidade < 0) {
            this.velocidadeAtual = 0;
            System.out.println("Trem freando. Parou completamente. Velocidade atual: 0 km/h.");
        } else {
            this.velocidadeAtual = novaVelocidade;
            System.out.println("Trem freando. Velocidade atual: " + this.velocidadeAtual + " km/h.");
        }
    }
}