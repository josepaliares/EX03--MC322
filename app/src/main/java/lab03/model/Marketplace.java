package lab03.model;

import java.util.ArrayList;
import java.util.List;

import lab03.exceptions.OfertaNaoEncontradaException;
import lab03.exceptions.SaldoInsuficienteException;

import lab03.*;

/**
 * Classe responsável por gerenciar as ofertas de ingressos para venda entre usuários.
 * Implementa a funcionalidade de marketplace onde clientes podem vender e comprar ingressos.
 */
public class Marketplace {
    private List<OfertaIngresso> ofertasDisponiveis;
    private double comissaoPorcentagem;
    
    /**
     * Construtor do Marketplace que inicializa a lista de ofertas e define a comissão padrão.
     * 
     * @param comissaoPorcentagem Percentual de comissão aplicado às vendas (0.0 a 1.0)
     */
    public Marketplace(double comissaoPorcentagem) {
        this.ofertasDisponiveis = new ArrayList<>();
        this.comissaoPorcentagem = comissaoPorcentagem;
    }
    
    /**
     * Lista todas as ofertas disponíveis no marketplace.
     * 
     * @return Lista de ofertas de ingressos disponíveis
     */
    public List<OfertaIngresso> listarOfertas() {
        return new ArrayList<>(ofertasDisponiveis);
    }
    
    /**
     * Recebe uma nova oferta de ingresso para ser vendida no marketplace.
     * 
     * @param vendedor Cliente que está vendendo o ingresso
     * @param ingresso Ingresso a ser vendido
     * @param precoPedido Preço solicitado pelo vendedor
     * @return Oferta criada e adicionada ao marketplace
     */
    public OfertaIngresso receberOferta(Cliente vendedor, Ingresso ingresso, double precoPedido) {
        OfertaIngresso oferta = new OfertaIngresso(vendedor, ingresso, precoPedido);
        ofertasDisponiveis.add(oferta);
        return oferta;
    }
    
    /**
     * Remove uma oferta do marketplace.
     * 
     * @param oferta Oferta a ser removida
     * @throws OfertaNaoEncontradaException Se a oferta não existir no marketplace
     */
    public void removerOferta(OfertaIngresso oferta) throws OfertaNaoEncontradaException {
        if (!ofertasDisponiveis.contains(oferta)) {
            throw new OfertaNaoEncontradaException("Oferta não encontrada no marketplace");
        }
        ofertasDisponiveis.remove(oferta);
    }
    
    /**
     * Processa a compra de um ingresso do marketplace, transferindo a propriedade
     * do ingresso para o comprador, calculando e cobrando a comissão.
     * 
     * @param comprador Cliente que está comprando o ingresso
     * @param oferta Oferta a ser comprada
     * @throws OfertaNaoEncontradaException Se a oferta não existir no marketplace
     * @throws SaldoInsuficienteException Se o comprador não tiver saldo suficiente
     */
    public void processarCompra(Cliente comprador, OfertaIngresso oferta) 
            throws OfertaNaoEncontradaException, SaldoInsuficienteException {
        // Verifica se a oferta existe no marketplace
        if (!ofertasDisponiveis.contains(oferta)) {
            throw new OfertaNaoEncontradaException("Oferta não encontrada no marketplace");
        }
        
        Cliente vendedor = oferta.getVendedor();
        Ingresso ingresso = oferta.getIngresso();
        double precoFinal = oferta.getPrecoPedido();
        
        // Verifica se o comprador tem saldo suficiente
        if (comprador.getSaldo() < precoFinal) {
            throw new SaldoInsuficienteException("Saldo insuficiente para concluir a compra");
        }
        
        // Calcula a comissão
        double valorComissao = precoFinal * comissaoPorcentagem;
        double valorVendedor = precoFinal - valorComissao;
        
        // Transfere o dinheiro
        comprador.debitarSaldo(precoFinal);
        vendedor.adicionarSaldo(valorVendedor);
        
        // Transfere o ingresso
        ingresso.setCliente(comprador);
        comprador.adicionarIngresso(ingresso);
        
        // Remove a oferta do marketplace
        ofertasDisponiveis.remove(oferta);
    }
    
    /**
     * Retorna a porcentagem de comissão atual do marketplace.
     * 
     * @return Porcentagem de comissão (0.0 a 1.0)
     */
    public double getComissaoPorcentagem() {
        return comissaoPorcentagem;
    }
    
    /**
     * Define a porcentagem de comissão do marketplace.
     * 
     * @param comissaoPorcentagem Nova porcentagem de comissão (0.0 a 1.0)
     */
    public void setComissaoPorcentagem(double comissaoPorcentagem) {
        this.comissaoPorcentagem = comissaoPorcentagem;
    }
}