package lab03.ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lab03.exceptions.IngressoNaoPertenceAoClienteException;
import lab03.exceptions.OfertaNaoEncontradaException;
import lab03.exceptions.SaldoInsuficienteException;
import lab03.model.*;
import lab03.filters.*;
import lab03.*;

/**
 * Classe Facade que serve como ponto de acesso único para a GUI interagir com a lógica de negócio.
 * Implementa o padrão Singleton para garantir uma única instância.
 */
public class SistemaFacade {
    private static SistemaFacade instance;
    
    private List<Evento> eventos;
    private List<Cliente> clientes;
    private List<Local> locais;
    private List<Organizadora> organizadoras;
    private Marketplace marketplace;
    private Cliente clienteLogado; // Cliente atualmente "logado" na aplicação
    
    /**
     * Construtor privado para implementar o padrão Singleton.
     */
    private SistemaFacade() {
        eventos = new ArrayList<>();
        clientes = new ArrayList<>();
        locais = new ArrayList<>();
        organizadoras = new ArrayList<>();
        marketplace = new Marketplace(0.1); // 10% de comissão
    }
    
    /**
     * Retorna a instância única do SistemaFacade.
     * 
     * @return Instância do SistemaFacade
     */
    public static SistemaFacade getInstance() {
        if (instance == null) {
            instance = new SistemaFacade();
        }
        return instance;
    }
    
    /**
     * Inicializa o sistema com dados de exemplo.
     */
    public void inicializarDadosExemplo() {
        // Cria locais
        Local local1 = new Local("Teatro Municipal", "Rua das Flores, 123", 500);
        Local local2 = new Local("Estádio Central", "Av. dos Esportes, 456", 30000);
        Local local3 = new Local("Centro de Convenções", "Praça da Cultura, 789", 1500);
        
        locais.add(local1);
        locais.add(local2);
        locais.add(local3);
        
        // Cria organizadoras
        Organizadora org1 = new Organizadora("Shows SA", "shows@exemplo.com");
        Organizadora org2 = new Organizadora("Esportes Brasil", "esportes@exemplo.com");
        Organizadora org3 = new Organizadora("Cultural Eventos", "cultural@exemplo.com");
        
        organizadoras.add(org1);
        organizadoras.add(org2);
        organizadoras.add(org3);
        
        // Cria eventos
        LocalDateTime agora = LocalDateTime.now();
        
        Evento evento1 = new Show("Show do Rock", agora.plusDays(30), 150.0, local1, org1, "Rock Band");
        Evento evento2 = new Esportivo("Campeonato de Futebol", agora.plusDays(15), 80.0, local2, org2, "Futebol");
        Evento evento3 = new Cultural("Exposição de Arte", agora.plusDays(7), 50.0, local3, org3, "Contemporânea");
        
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        
        // Cria clientes com saldo inicial
        Cliente cliente1 = new Cliente("João Silva", "joao@email.com", 1000.0);
        Cliente cliente2 = new Cliente("Maria Souza", "maria@email.com", 800.0);
        Cliente cliente3 = new Cliente("Pedro Santos", "pedro@email.com", 1200.0);
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        
        // Compra alguns ingressos iniciais
        Ingresso ingresso1 = evento1.venderIngresso(cliente1);
        Ingresso ingresso2 = evento2.venderIngresso(cliente1);
        Ingresso ingresso3 = evento1.venderIngresso(cliente2);
        Ingresso ingresso4 = evento3.venderIngresso(cliente3);
        
        // Define cliente1 como logado inicialmente
        clienteLogado = cliente1;
    }
    
    /**
     * Retorna a lista de todos os eventos.
     * 
     * @return Lista de eventos
     */
    public List<Evento> getEventos() {
        return new ArrayList<>(eventos);
    }
    
    /**
     * Busca eventos pelo nome.
     * 
     * @param nome Nome a ser buscado
     * @return Lista de eventos que correspondem ao nome
     */
    public List<Evento> buscarEventosPorNome(String nome) {
        CriteriaEvento criteria = new CriteriaNome(nome);
        return criteria.meetCriteria(eventos);
    }
    
    /**
     * Retorna a lista de todos os clientes.
     * 
     * @return Lista de clientes
     */
    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }
    
    /**
     * Retorna o cliente atualmente logado.
     * 
     * @return Cliente logado
     */
    public Cliente getClienteLogado() {
        return clienteLogado;
    }
    
    /**
     * Define o cliente logado.
     * 
     * @param cliente Cliente a ser logado
     */
    public void setClienteLogado(Cliente cliente) {
        this.clienteLogado = cliente;
    }
    
    /**
     * Compra um ingresso de um evento para o cliente logado.
     * 
     * @param evento Evento do qual se deseja comprar o ingresso
     * @return Ingresso comprado
     * @throws SaldoInsuficienteException Se o cliente não tiver saldo suficiente
     */
    public Ingresso comprarIngresso(Evento evento) throws SaldoInsuficienteException {
        if (clienteLogado == null) {
            throw new IllegalStateException("Nenhum cliente está logado");
        }
        
        double precoIngresso = evento.getPrecoIngresso();
        
        if (clienteLogado.getSaldo() < precoIngresso) {
            throw new SaldoInsuficienteException("Saldo insuficiente para comprar o ingresso");
        }
        
        try {
            clienteLogado.debitarSaldo(precoIngresso);
            return evento.venderIngresso(clienteLogado);
        } catch (Exception e) {
            // Se algo der errado, devolve o dinheiro ao cliente
            clienteLogado.adicionarSaldo(precoIngresso);
            throw e;
        }
    }
    
    /**
     * Retorna a lista de ofertas disponíveis no marketplace.
     * 
     * @return Lista de ofertas
     */
    public List<OfertaIngresso> getOfertasMarketplace() {
        return marketplace.listarOfertas();
    }
    
    /**
     * Oferece um ingresso do cliente logado para venda no marketplace.
     * 
     * @param ingresso Ingresso a ser vendido
     * @param precoPedido Preço solicitado
     * @return Oferta criada
     * @throws IngressoNaoPertenceAoClienteException Se o ingresso não pertencer ao cliente
     */
    public OfertaIngresso oferecerIngressoParaVenda(Ingresso ingresso, double precoPedido) 
            throws IngressoNaoPertenceAoClienteException {
        if (clienteLogado == null) {
            throw new IllegalStateException("Nenhum cliente está logado");
        }
        
        return clienteLogado.oferecerIngressoParaVenda(ingresso, precoPedido, marketplace);
    }
    
    /**
     * Compra um ingresso disponível no marketplace para o cliente logado.
     * 
     * @param oferta Oferta a ser comprada
     * @throws OfertaNaoEncontradaException Se a oferta não existir no marketplace
     * @throws SaldoInsuficienteException Se o cliente não tiver saldo suficiente
     */
    public void comprarIngressoNoMarketplace(OfertaIngresso oferta) 
            throws OfertaNaoEncontradaException, SaldoInsuficienteException {
        if (clienteLogado == null) {
            throw new IllegalStateException("Nenhum cliente está logado");
        }
        
        clienteLogado.comprarIngressoNoMarketplace(oferta, marketplace);
    }
    
    /**
     * Retorna a porcentagem de comissão do marketplace.
     * 
     * @return Porcentagem de comissão (0.0 a 1.0)
     */
    public double getComissaoMarketplace() {
        return marketplace.getComissaoPorcentagem();
    }
    
    /**
     * Retorna a instância do marketplace.
     * 
     * @return Marketplace
     */
    public Marketplace getMarketplace() {
        return marketplace;
    }
}