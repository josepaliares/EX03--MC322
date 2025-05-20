package lab03.exceptions;

/**
 * Exceção lançada quando o cancelamento de um evento não é permitido.
 */
public class IngressoNaoEncontradoException extends Exception {
    public IngressoNaoEncontradoException(String message) {
        super(message);
    }
}
