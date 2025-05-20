/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

import lab03.exceptions.IngressoEsgotadoException;
import lab03.model.Cliente;

public abstract class Evento {
    protected String nome;
    protected Local local;
    protected double precoIngresso; // preço base do ingresso
    protected Organizadora organizadora;
    protected String data;
    protected int capacidade;
    protected int ingressosRestantes;

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param local o local associado ao Evento
     */
    public Evento(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, int capacidade) {
        this.nome = nome;
        this.local = local;
        local.setDisponivel(false);
        this.precoIngresso = precoIngresso; // modificar para representar o preço base do ingresso
        this.organizadora = organizadora;
        this.data = data;
        this.capacidade = capacidade;
        this.ingressosRestantes = capacidade;
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do evento não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Altera o local do Evento para `local` 
     * @param local o novo local do Evento
     */
    public void setLocal(Local local) {
        if (local == null) {
            throw new IllegalArgumentException("Local não pode ser nulo.");
        }
        this.local = local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(double precoIngresso){
        if (precoIngresso <= 0) {
            throw new IllegalArgumentException("Preço do ingresso deve ser maior que zero.");
        }
        this.precoIngresso = precoIngresso;
    }

    /**
     * Retorna a capacidade do Evento
     * @return a capacidade do Evento
     */
    public int getCapacidade() {
        return capacidade;
    }

    public String descricao(){
        return "Evento: " + this.nome + " - Local: " + this.local;
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public String getData() {
        return data;
    }

    /**
     * Retorna a organizadora do Evento
     * @return a organizadora do Evento
     */
    public Organizadora getOrganizadora() {
        return organizadora;
    }

    /**
     * Vende um ingresso para o cliente
     * @param cliente o cliente que está comprando o ingresso
     * @throws IngressoEsgotadoException se não houver ingressos disponíveis
     * @throws IllegalArgumentException se o cliente for nulo
     */
    public void venderIngresso(Cliente cliente) throws IngressoEsgotadoException{
        // Tratar evento não encontrado no App

        if (cliente == null) {
            throw new IllegalArgumentException("Insira um cliente válido.");
        }
        if (this.ingressosRestantes == 0) {
            throw new IngressoEsgotadoException("Ingressos esgotados.");
        }

        Ingresso ingresso = new Ingresso(this, this.precoIngresso);
        cliente.getIngressos().add(ingresso);

        this.ingressosRestantes--;
        System.out.println("Ingresso vendido com sucesso para o cliente: " + cliente.getNome());
    }

    /**
     * Altera a quantia de ingressos restantes
     * @param ingressosRestantes a nova quantidade de ingressos restantes
     */
    public void setIngressosRestantes(int ingressosRestantes) {
        this.ingressosRestantes = ingressosRestantes;
    }

    /**
     * Retorna a quantidade de ingressos restantes
     * @return a quantidade de ingressos restantes
     */
    public int getIngressosRestantes() {
        return ingressosRestantes;
    }
}