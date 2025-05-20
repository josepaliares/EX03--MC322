package lab03;

import java.util.ArrayList;
import java.util.List;

import lab03.filters.Filter;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;
    private final List<Evento> eventos;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.eventos = new ArrayList<>();
    }

    /**
     * Retorna o nome da organizadora
     * @return o nome da organizadora
     */
    public String getNome() {
        return nome;
    }
    /**
     * Altera o nome da organizadora para `nome` 
     * @param nome o novo nome da organizadora
     */
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    /**
     * Retorna o CNPJ da organizadora
     * @return o CNPJ da organizadora
     */
    public int getCnpj() {
        return cnpj;
    }
    /**
     * Altera o CNPJ da organizadora para `cnpj` 
     * @param cnpj o novo CNPJ da organizadora
     */
    public void setCnpj(int cnpj) {
        if (cnpj < 1000000000) {
            throw new IllegalArgumentException("CNPJ não pode ser menor que 10 dígitos.");
        }
        this.cnpj = cnpj;
    }

    /**
     * Retorna o endereço da organizadora
     * @return o endereço da organizadora
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Altera o endereço da organizadora para `endereco` 
     * @param endereco o novo endereço da organizadora
     */
    public void setEndereco(String endereco) {
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio.");
        }
        this.endereco = endereco;
    }

    /**
     * Retorna a lista de eventos da organizadora
     * @return a lista de eventos da organizadora
     */
    public List<Evento> getEventos() {
        return eventos;
    }
    /**
     * Adiciona um evento à lista de eventos da organizadora
     * @param evento o evento a ser adicionado
     */
    public void adicionarEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Evento não pode ser nulo.");
        }
        this.eventos.add(evento);
    }
    /**
     * Remove um evento da lista de eventos da organizadora
     * @param evento o evento a ser removido
     */
    public void removerEvento(Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Evento não pode ser nulo.");
        }
        this.eventos.remove(evento);
    }

    /**
     * Cria um evento do tipo EventoFestival
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param data a data do evento
     * @param lineup a lista de artistas que se apresentarão no evento
     * @param duracao a duração do evento em horas
     * @return um evento do tipo EventoFestival
     */
    public EventoFestival criarEvento(String nome, Local local, double precoIngresso, String data, List<String> lineup, int duracao, int capacidade) {
        return new EventoFestival(nome, local, precoIngresso, this, data, capacidade, lineup, duracao);
    }
    /**
     * Cria um evento do tipo EventoJogo
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param data a data do evento
     * @param times a lista de times que se enfrentarão no evento
     * @return um evento do tipo EventoJogo
     */
    public EventoJogo criarEvento(String nome, Local local, double precoIngresso, String data, List<String> times, int capacidade) {
        return new EventoJogo(nome, local, precoIngresso, this, data, capacidade, times);
    }
    /**
     * Cria um evento do tipo EventoShow
     * @param nome o nome do evento
     * @param local o local do evento
     * @param precoIngresso o preço do ingresso do evento
     * @param data a data do evento
     * @param artista o artista que se apresentará no evento
     * @return um evento do tipo EventoShow
     */
    public EventoShow criarEvento(String nome, Local local, double precoIngresso, String data, String artista, int capacidade) {
        return new EventoShow(nome, local, precoIngresso, this, data, capacidade, artista);
    }

    /**
     * Busca eventos com base em um filtro
     * @param filtro o filtro a ser aplicado na busca
     * @return uma lista de eventos que atendem ao filtro
     */
    public List<Evento> buscarEventos(Filter<Evento> filtro) {
        List<Evento> resultado = new ArrayList<>();
        for (Evento evento : eventos) {
            if (filtro.matches(evento)) {
                resultado.add(evento);
            }
        }
        return resultado;
    }
}
