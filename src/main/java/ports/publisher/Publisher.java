package ports.publisher;

public interface Publisher<T> {
    void publish(T entity);
}
