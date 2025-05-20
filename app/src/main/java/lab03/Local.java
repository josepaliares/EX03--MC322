/*
 * Local.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab03;

/**
 * Contém a estrutura de implementação de um Local.
 * 
 * @author Jose Paliares - 260634
 */

import lab03.exceptions.CapacidadeInsuficienteException;
import lab03.exceptions.LocalIndisponivelException;

public class Local{
    private String nome;
    private int capacidadeMaxima;
    private boolean disponivel;

    /**
     * Construtor da classe Local
     * @param nome o nome do local
     */
    public Local(String nome, int capacidadeMaxima){
        this.nome = nome;
        this.capacidadeMaxima = capacidadeMaxima;
        this.disponivel = true;
    }

    /**
     * Retorna o nome do evento
     * @return o nome do evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do evento
     */
    public void setNome(String nome){
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Retorna a capacidade do local
     * @return a capacidade do local
     */
    public int getCapacidade(){
        return capacidadeMaxima;
    }
    /**
     * Retorna a disponibilidade do local
     * @return a disponibilidade do local
     */
    public boolean isDisponivel(){
        return disponivel;
    }
    /**
     * Altera a disponibilidade do local 
     * @param disponivel a nova disponibilidade do local
     */
    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }
    /**
     * Altera a capacidade máxima do local para `capacidadeMaxima` 
     * @param capacidadeMaxima a nova capacidade máxima do local
     */
    public void setCapacidade(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
    public void alocarParaEvento(Evento evento) throws CapacidadeInsuficienteException, LocalIndisponivelException {
        if (!this.disponivel) {
            throw new LocalIndisponivelException("O local não está disponível.");
        }
        if (evento.getCapacidade() > this.capacidadeMaxima) {
            throw new CapacidadeInsuficienteException("Capacidade insuficiente para o evento.");
        }
        evento.local.setDisponivel(true);
        evento.setLocal(this);
        this.disponivel = false;
    }
}
