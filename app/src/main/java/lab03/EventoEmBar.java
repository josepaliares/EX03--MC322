package lab03;

public class EventoEmBar extends CaracteristicaDeEvento {
    private String nomeDoBar;
    private String inicioHappyHour;
    private String duracaoHappyHour;

    public EventoEmBar(String nomeDoBar, String inicioHappyHour, String duracaoHappyHour) {
        this.nomeDoBar = nomeDoBar;
        this.inicioHappyHour = inicioHappyHour;
        this.duracaoHappyHour = duracaoHappyHour;
    }

    @Override
    public String descricao() {
        return "Evento no bar " + nomeDoBar + ", Happy Hour Inicio: " + inicioHappyHour + ", Duração: " + duracaoHappyHour;
    }

    /**
     * Retorna o nome do bar
     * @return nomeDoBar
     */
    public String getNomeDoBar() {
        return nomeDoBar;
    }
    /**
     * Altera o nome do bar
     * @param nomeDoBar nome do bar
     */
    public void setNomeDoBar(String nomeDoBar) {
        if (nomeDoBar == null || nomeDoBar.isEmpty()) {
            throw new IllegalArgumentException("Nome do bar não pode ser nulo ou vazio.");
        }
        this.nomeDoBar = nomeDoBar;
    }
    /**
     * Retorna o inicio do happy hour
     * @return inicioHappyHour
     */
    public String getInicioHappyHour() {
        return inicioHappyHour;
    }
    /**
     * Altera o inicio do happy hour
     * @param inicioHappyHour inicio do happy hour
     */
    public void setInicioHappyHour(String inicioHappyHour) {
        if (inicioHappyHour == null || inicioHappyHour.isEmpty()) {
            throw new IllegalArgumentException("Inicio do happy hour não pode ser nulo ou vazio.");
        }
        this.inicioHappyHour = inicioHappyHour;
    }
    /**
     * Retorna a duracao do happy hour
     * @return duracaoHappyHour
     */
    public String getDuracaoHappyHour() {
        return duracaoHappyHour;
    }
    /**
     * Altera a duracao do happy hour
     * @param duracaoHappyHour duracao do happy hour
     */
    public void setDuracaoHappyHour(String duracaoHappyHour) {
        if (duracaoHappyHour == null || duracaoHappyHour.isEmpty()) {
            throw new IllegalArgumentException("Duração do happy hour não pode ser nulo ou vazio.");
        }
        this.duracaoHappyHour = duracaoHappyHour;
    }
}
