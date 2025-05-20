/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

/**
 * Contém a estrutura de implementação de um Ingresso.
 */
public class Ingresso {

    private Evento evento;
    private double preco;

    /**
     * Construtor da classe Ingresso
     * @param preco o preço do Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public Ingresso(Evento evento, double preco) {
        this.evento = evento;
        this.preco = preco;
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public double getPreco() {

        return this.preco;
    }

    /**
     * Altera o preço do Ingresso para `preco` 
     * @param preco o novo preço do Ingresso
     */
    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço do ingresso deve ser maior que zero.");
        }
        this.preco = preco;
    }
    
    /**
     * Retorna o evento associado ao Ingresso
     * @return o evento associado ao Ingresso
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * Define o evento associado ao Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public void setEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Evento não pode ser nulo.");
        }
        this.evento = evento;
    }
}
