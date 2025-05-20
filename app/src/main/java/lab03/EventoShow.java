/*

 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab03;

public class EventoShow extends Evento {
        
    private String artista;
    
    /**
    * Construtor da classe EventocShow
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param artista o artista do Evento
    * @param organizadora a organizadora do Evento
    */
    public EventoShow(String nome, Local local, double precoIngresso, Organizadora organizadora, String data, int capacidade, String artista) {
        super(nome, local, precoIngresso, organizadora, data, capacidade);
        this.artista = artista;

    }

    /**
     * Retorna o artista do Evento
     * @return o artista do Evento
     */
    public String getArtista() {
        return artista;
    }
    /**
     * Altera o artista do Evento para `artista` 
     * @param artista o novo artista do Evento
     */
    public void setArtista(String artista) {
        if (artista == null || artista.isEmpty()) {
            throw new IllegalArgumentException("Artista não pode ser nulo ou vazio.");
        }
        this.artista = artista;
    }

    /**
    * Retorna a descrição do Evento
    * @return a descrição do Evento
    */
    public String getDescricao() {
        return "Show: " + this.nome + " - Artista: " + this.artista  + " - Local: " + this.local + " - Data: " + this.data;
    }
}
