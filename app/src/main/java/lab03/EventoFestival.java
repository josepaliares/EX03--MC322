/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

import java.util.List;

public class EventoFestival extends Evento {
        
    private List<String> lineup;
    private int duracao;
    
    /**
    * Construtor da classe EventoFestival
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    */
    public EventoFestival(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, int capacidade, List<String> lineup, int duracao) {
        super(nome, local, precoIngresso, organizadora, data, capacidade);
        this.lineup = lineup;
        this.duracao = duracao;
    }

    
    /**
    * Retorna a dura o do Festival em dias
    * @return a dura o do Festival
    */
    public int getDuracao() {
        return this.duracao;
    }
    
    /**
     * Altera a duracao do Festival para `duracao`
     * @param duracao a nova duracao do Festival
     */
    public void setDuracao(int duracao) {
        if (duracao <= 0) {
            throw new IllegalArgumentException("Duração deve ser maior que zero.");
        }
        this.duracao = duracao;
    }
    
    /**
    * Retorna a lista com os nomes dos artistas que se apresentarão no Festival
    * @return a lista com os nomes dos artistas do Festival
    */
    public List<String> getLineup() {
        return this.lineup;
    }
    
    /**
     * Altera o lineup do Festival para `lineup`
     * @param lineup a nova lista de artistas do Festival
     */
    public void setLineup(List<String> lineup) {
        if (lineup == null || lineup.isEmpty()) {
            throw new IllegalArgumentException("Lineup não pode ser nulo ou vazio.");
        }
        this.lineup = lineup;
    }

    /**
     * Retorna uma string contendo a descri o do Festival, com seu nome, lineup, local e dura o
     * @return uma string com a descri o do Festival
     */
    @Override
    public String descricao() {
        return "Festival: " + this.nome + " - Lineup: " + this.lineup + " - Local: " + this.local + " - Duração: " + this.duracao;
    }

    /**
    * Retorna o preço do Ingresso do Evento
    * @return o preço do Ingresso do Evento
    */
    @Override
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }
}
