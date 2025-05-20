package lab03.exceptions;

/**
 * Exceção lançada quando o cancelamento de um evento não é permitido.
 */
public class CancelamentoNaoPermitidoException extends Exception {
    public CancelamentoNaoPermitidoException(String message) {
        super(message);
    }
}
