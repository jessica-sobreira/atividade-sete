package tarefa5;

public class PagamentoInvalidoException extends IllegalArgumentException {
    public PagamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}