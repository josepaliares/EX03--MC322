package lab03.model;

import java.util.ArrayList;
import java.util.List;

import lab03.exceptions.IngressoNaoPertenceAoClienteException;
import lab03.exceptions.OfertaNaoEncontradaException;
import lab03.exceptions.SaldoInsuficienteException;
import lab03.notifications.Observer;

import lab03.*;

/**
 * Classe que representa um cliente no sistema de eventos.
 * Ampliada com funcionalidades para interagir com o Marketplace.
 */
public class Cliente implements Observer {
    private String nome;
    private String email;
    private List<Ingresso> ingressos;
    private List<String> notificacoes;
    private double saldo; // Novo atributo para controle financeiro
    
    /**
     * Construtor do cliente.
     * 
     * @param nome Nome do cliente
     * @param email Email do cliente
     * @param saldoInicial Saldo inicial do cliente
     */
    public Cliente(String nome, String email, double saldoInicial) {
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<>();
        this.notificacoes = new ArrayList<>();
        this.saldo = saldoInicial;
    }
    
    /**
     * Construtor alternativo sem saldo inicial (usado para compatibilidade).
     * 
     * @param nome Nome do cliente
     * @param email Email do cliente
     */
    public Cliente(String nome, String email) {
        this(nome, email, 0.0); // Saldo inicial zero
    }
    
    /**
     * Retorna o nome do cliente.
     * 
     * @return Nome do cliente
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Retorna o email do cliente.
     * 
     * @return Email do cliente
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Adiciona um ingresso à lista de ingressos do cliente.
     * 
     * @param ingresso Ingresso a ser adicionado
     */
    public void adicionarIngresso(Ingresso ingresso) {
        this.ingressos.add(ingresso);
    }
    
    /**
     * Remove um ingresso da lista de ingressos do cliente.
     * 
     * @param ingresso Ingresso a ser removido
     * @return true se o ingresso foi removido, false caso contrário
     */
    public boolean removerIngresso(Ingresso ingresso) {
        return this.ingressos.remove(ingresso);
    }
    
    /**
     * Retorna a lista de ingressos do cliente.
     * 
     * @return Lista de ingressos
     */
    public List<Ingresso> getIngressos() {
        return new ArrayList<>(ingressos);
    }
    
    /**
     * Verifica se o cliente possui um determinado ingresso.
     * 
     * @param ingresso Ingresso a ser verificado
     * @return true se o cliente possui o ingresso, false caso contrário
     */
    public boolean possuiIngresso(Ingresso ingresso) {
        return this.ingressos.contains(ingresso);
    }
    
    /**
     * Retorna o saldo atual do cliente.
     * 
     * @return Saldo atual
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Adiciona valor ao saldo do cliente.
     * 
     * @param valor Valor a ser adicionado
     */
    public void adicionarSaldo(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }
    
    /**
     * Debita valor do saldo do cliente.
     * 
     * @param valor Valor a ser debitado
     * @throws SaldoInsuficienteException Se o cliente não tiver saldo suficiente
     */
    public void debitarSaldo(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para a operação");
        }
        this.saldo -= valor;
    }
    
    /**
     * Oferece um ingresso para venda no marketplace.
     * 
     * @param ingresso Ingresso a ser vendido
     * @param precoPedido Preço solicitado pelo cliente
     * @param marketplace Marketplace onde o ingresso será oferecido
     * @return A oferta criada
     * @throws IngressoNaoPertenceAoClienteException Se o ingresso não pertencer ao cliente
     */
    public OfertaIngresso oferecerIngressoParaVenda(Ingresso ingresso, double precoPedido, Marketplace marketplace) 
            throws IngressoNaoPertenceAoClienteException {
        if (!possuiIngresso(ingresso)) {
            throw new IngressoNaoPertenceAoClienteException("Este ingresso não pertence ao cliente " + this.nome);
        }
        
        // Remove o ingresso da lista do cliente
        removerIngresso(ingresso);
        
        // Adiciona ao marketplace
        return marketplace.receberOferta(this, ingresso, precoPedido);
    }
    
    /**
     * Compra um ingresso disponível no marketplace.
     * 
     * @param oferta Oferta a ser comprada
     * @param marketplace Marketplace onde a oferta está disponível
     * @throws OfertaNaoEncontradaException Se a oferta não existir no marketplace
     * @throws SaldoInsuficienteException Se o cliente não tiver saldo suficiente
     */
    public void comprarIngressoNoMarketplace(OfertaIngresso oferta, Marketplace marketplace) 
            throws OfertaNaoEncontradaException, SaldoInsuficienteException {
        marketplace.processarCompra(this, oferta);
    }
    
    /**
     * Implementação do método de atualização do Observer.
     * Recebe notificações de eventos.
     * 
     * @param mensagem Mensagem de notificação
     */
    @Override
    public void update(String mensagem) {
        notificacoes.add(mensagem);
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }
    
    /**
     * Retorna a lista de notificações do cliente.
     * 
     * @return Lista de notificações
     */
    public List<String> getNotificacoes() {
        return new ArrayList<>(notificacoes);
    }
    
    /**
     * Retorna uma representação em string do cliente.
     * 
     * @return String com informações do cliente
     */
    @Override
    public String toString() {
        return "Cliente: " + nome + " (" + email + ") - Saldo: R$" + String.format("%.2f", saldo);
    }
}