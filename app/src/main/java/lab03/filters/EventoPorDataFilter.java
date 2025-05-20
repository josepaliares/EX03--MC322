package lab03.filters;
import lab03.Evento;

public class EventoPorDataFilter implements Filter<Evento> {
    private final String dataProcurada;

    public EventoPorDataFilter(String dataProcurada) {
        this.dataProcurada = dataProcurada;
    }

    @Override
    public boolean matches(Evento evento) {
        return evento.getData().equalsIgnoreCase(dataProcurada);
    }
}
