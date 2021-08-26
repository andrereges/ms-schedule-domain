package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"id", "name", "createAt"})
@ToString(of = {"id", "name"})
public class Client {

    private String id;
    private String name;
    private List<Schedule> schedules;
    private LocalDateTime createdAt;

    public Client(String id, String name, List<Schedule> schedules, LocalDateTime createdAt) {
        validateConstructor(name, createdAt);

        this.id = id;
        this.name = name;
        this.schedules = schedules;
        this.createdAt = createdAt;
    }

    private void validateConstructor(String name, LocalDateTime createdAt) {
        if (name == null || name != null && name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty or null");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }

}
