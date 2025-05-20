package lab03.model;

import lab03.Ingresso;

/**
 * Classe que representa uma oferta de ingresso disponível no marketplace.
 * Contém informações sobre o vendedor, o ingresso e o preço pedido.
 */
public class OfertaIngresso {
    private Cliente vendedor;
    private Ingresso ingresso;
    private double precoPedido;
    
    /**
     * Construtor da oferta de ingresso.
     * 
     * @param vendedor Cliente que está vendendo o ingresso
     * @param ingresso Ingresso que está sendo vendido
     * @param precoPedido Preço solicitado pelo vendedor
     */
    public OfertaIngresso(Cliente vendedor, Ingresso ingresso, double precoPedido) {
        this.vendedor = vendedor;
        this.ingresso = ingresso;
        this.precoPedido = precoPedido;
    }
    
    /**
     * Retorna o cliente vendedor do ingresso.
     * 
     * @return Cliente vendedor
     */
    public Cliente getVendedor() {
        return vendedor;
    }
    
    /**
     * Retorna o ingresso que está sendo oferecido.
     * 
     * @return Ingresso oferecido
     */
    public Ingresso getIngresso() {
        return ingresso;
    }
    
    /**
     * Retorna o preço pedido pelo vendedor.
     * 
     * @return Preço pedido
     */
    public double getPrecoPedido() {
        return precoPedido;
    }
    
    /**
     * Define um novo preço para a oferta.
     * 
     * @param precoPedido Novo preço pedido
     */
    public void setPrecoPedido(double precoPedido) {
        this.precoPedido = precoPedido;
    }
    
    /**
     * Retorna uma representação em string da oferta de ingresso.
     * 
     * @return String com informações da oferta
     */
    @Override
    public String toString() {
        return "Oferta: " + ingresso.getEvento().getNome() + 
               " - Vendedor: " + vendedor.getNome() + 
               " - Preço: R$" + String.format("%.2f", precoPedido);
    }
}