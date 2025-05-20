package lab03.exceptions;

/**
 * Exceção lançada quando os ingressos de um evento estão esgotados.
 */
public class IngressoEsgotadoException extends Exception{
    public IngressoEsgotadoException(String message) {
        super(message);
    }
}
