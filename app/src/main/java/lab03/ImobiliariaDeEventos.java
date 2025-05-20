/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDeEventos {
    
    private final List<Local> locais;
    private String nome;


    /**
     * Construtor da classe ImobiliariaDeEventos
     * @param nome o nome da imobiliária de eventos
     */
    public ImobiliariaDeEventos(String nome) {
        this.nome = nome;
        this.locais = new ArrayList<>();
    }

    /**
     * Retorna o nome da imobiliária de eventos
     * @return o nome da imobiliária de eventos
     */
    public String getNome() {
        return nome;
    }
    /**
     * Altera o nome da imobiliária de eventos para `nome` 
     * @param nome o novo nome da imobiliária de eventos
     */
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }
    
    /**
     * Adiciona um local à lista de locais disponíveis
     * @param local o local a ser adicionado
     */
    public void adicionarLocal(Local local) {
        this.locais.add(local);
    }

    /**
     * Busca um local pelo nome
     * @param nome o nome do local
     * @return o local encontrado ou null se não encontrado
     */
    public Local buscarLocal(String nome) {
        for (Local local : locais) {
            if (local.getNome().equalsIgnoreCase(nome)) {
                return local;
            }
        }
        return null;
    }

    /**
     * Busca um local pela capacidade
     * @param capacidadeMaxima a capacidade do local
     * @return o local encontrado ou null se não encontrado
     */
    public Local buscarLocal(double capacidadeMaxima) {
        for (Local local : locais) {
            if (local.getCapacidade() == capacidadeMaxima) {
                return local;
            }
        }
        return null;
    }
}
