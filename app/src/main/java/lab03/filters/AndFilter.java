package lab03.filters;

import java.util.ArrayList;
import java.util.List;

public class AndFilter<T> implements Filter<T> {
    private final List<Filter<T>> filtros;

    public AndFilter() {
        this.filtros = new ArrayList<>();
    }

    public void adicionarFiltro(Filter<T> filtro) {
        filtros.add(filtro);
    }

    @Override
    public boolean matches(T t) {
        for (Filter<T> filtro : filtros) {
            if (!filtro.matches(t)) {
                return false;
            }
        }
        return true;
    }
}
