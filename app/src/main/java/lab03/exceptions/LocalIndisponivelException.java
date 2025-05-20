package lab03.exceptions;

/**
 * Exceção lançada quando o cancelamento de um evento não é permitido.
 */
public class LocalIndisponivelException extends Exception {
    public LocalIndisponivelException(String message) {
        super(message);
    }
}
