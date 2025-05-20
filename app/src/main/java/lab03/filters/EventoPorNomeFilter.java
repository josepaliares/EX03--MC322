package lab03.filters;
import lab03.Evento;

public class EventoPorNomeFilter implements Filter<Evento> {
    private final String nomeProcurado;

    public EventoPorNomeFilter(String nomeProcurado) {
        this.nomeProcurado = nomeProcurado;
    }

    @Override
    public boolean matches(Evento evento) {
        return evento.getNome().equalsIgnoreCase(nomeProcurado);
    }
}