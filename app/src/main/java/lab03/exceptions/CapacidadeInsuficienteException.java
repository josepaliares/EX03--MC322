package lab03.exceptions;

/**
 * Exceção lançada quando o cancelamento de um evento não é permitido.
 */
public class CapacidadeInsuficienteException extends Exception {
    public CapacidadeInsuficienteException(String message) {
        super(message);
    }
}
