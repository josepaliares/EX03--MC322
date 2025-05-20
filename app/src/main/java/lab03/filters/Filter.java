package lab03.filters;

public interface Filter<T> {
    boolean matches(T t);
}
