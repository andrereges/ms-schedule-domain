package ports.sender;

public interface MessageSender<T> {
    void sendMessageForCreated(T entity);

    void sendMessageForRetrieved(T entity);
}
