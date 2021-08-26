package ports.notifier;

public interface Notifier<T> {
    void notifyAboutCreationOf(T entity);
}
