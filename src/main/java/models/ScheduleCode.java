package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"id", "code", "createAt"})
@ToString(of = {"id", "code"})
public class ScheduleCode {

    private String id;
    private String code;
    private Client client;
    private LocalDateTime createdAt;

    public ScheduleCode(String id, String code, Client client, LocalDateTime createdAt) {
        validateConstructor(code, client, createdAt);

        this.id = id;
        this.code = code;
        this.client = client;
        this.createdAt = createdAt;
    }

    private void validateConstructor(String code, Client client, LocalDateTime createdAt) {
        if (code == null || code != null && code.isEmpty())
            throw new IllegalArgumentException("Code cannot be empty or null");

        if (client == null)
            throw new IllegalArgumentException("Client cannot be null");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }

}
