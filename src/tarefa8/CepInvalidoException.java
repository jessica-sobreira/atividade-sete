package tarefa8;

public class CepInvalidoException extends IllegalArgumentException {
    public CepInvalidoException(String mensagem) {
        super(mensagem);
    }
}