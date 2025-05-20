package lab03;

public class EventoMusicaAoVivo extends CaracteristicaDeEvento{
    private String nomeDoArtista;
    private String generoMusical;

    public EventoMusicaAoVivo(String nomeDoArtista, String generoMusical) {
        this.nomeDoArtista = nomeDoArtista;
        this.generoMusical = generoMusical;
    }

    @Override
    public String descricao() {
        return "Música ao vivo com " + nomeDoArtista + " (" + generoMusical + ")";
    }

    /**
     * Retorna o nome do artista
     * @return nomeDoArtista
     */
    public String getNomeDoArtista() {
        return nomeDoArtista;
    }
    /**
     * Altera o nome do artista
     * @param nomeDoArtista nome do artista
     */
    public void setNomeDoArtista(String nomeDoArtista) {
        if (nomeDoArtista == null || nomeDoArtista.isEmpty()) {
            throw new IllegalArgumentException("Nome do artista não pode ser nulo ou vazio.");
        }
        this.nomeDoArtista = nomeDoArtista;
    }
    /**
     * Retorna o genero musical
     * @return generoMusical
     */
    public String getGeneroMusical() {
        return generoMusical;
    }
    /**
     * Altera o genero musical
     * @param generoMusical genero musical
     */
    public void setGeneroMusical(String generoMusical) {
        if (generoMusical == null || generoMusical.isEmpty()) {
            throw new IllegalArgumentException("Gênero musical não pode ser nulo ou vazio.");
        }
        this.generoMusical = generoMusical;
    }
}
