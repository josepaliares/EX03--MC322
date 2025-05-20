package lab03.filters;
import lab03.Evento;

public class EventoPorLocalFilter implements Filter<Evento> {
    private final String localProcurado;

    public EventoPorLocalFilter(String localProcurado) {
        this.localProcurado = localProcurado;
    }

    @Override
    public boolean matches(Evento evento) {
        return evento.getLocal().getNome().equalsIgnoreCase(localProcurado);
    }
}
