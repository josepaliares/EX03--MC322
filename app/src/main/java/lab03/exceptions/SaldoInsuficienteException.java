package lab03.exceptions;

/**
 * Exceção lançada quando um cliente tenta fazer uma compra sem saldo suficiente.
 */
public class SaldoInsuficienteException extends Exception {
    
    /**
     * Construtor da exceção com uma mensagem de erro.
     * 
     * @param message Mensagem explicativa do erro
     */
    public SaldoInsuficienteException(String message) {
        super(message);
    }
}