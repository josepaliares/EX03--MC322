package lab03.filters;
import lab03.Evento;

public class EventoPorOrganizador implements Filter<Evento> {
    private final String organizadorProcurado;

    public EventoPorOrganizador(String organizadorProcurado) {
        this.organizadorProcurado = organizadorProcurado;
    }

    @Override
    public boolean matches(Evento evento) {
        return evento.getOrganizadora().getNome().equalsIgnoreCase(organizadorProcurado);
    }   
}
