package own.nio.utilities;

public interface Validation<T> {
    public void processData(T entity) throws IllegalArgumentException;
}
