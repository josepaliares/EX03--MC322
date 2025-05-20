package lab03.exceptions;

/**
 * Exceção lançada quando uma oferta não é encontrada no marketplace.
 */
public class OfertaNaoEncontradaException extends Exception {
    
    /**
     * Construtor da exceção com uma mensagem de erro.
     * 
     * @param message Mensagem explicativa do erro
     */
    public OfertaNaoEncontradaException(String message) {
        super(message);
    }
}