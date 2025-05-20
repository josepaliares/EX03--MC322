package lab03.exceptions;

/**
 * Exceção lançada quando um cliente tenta vender um ingresso que não lhe pertence.
 */
public class IngressoNaoPertenceAoClienteException extends Exception {
    
    /**
     * Construtor da exceção com uma mensagem de erro.
     * 
     * @param message Mensagem explicativa do erro
     */
    public IngressoNaoPertenceAoClienteException(String message) {
        super(message);
    }
}