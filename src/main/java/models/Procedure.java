package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"id", "name", "createdAt"})
@ToString(of = {"id", "name"})
public class Procedure {

    private String id;
    private String name;
    private String description;
    private boolean activated;
    private Double value;
    private LocalDateTime createdAt;

    public Procedure(String id, String name, String description, boolean activated, Double value, LocalDateTime createdAt) {
        validateConstructor(name, description, value, createdAt);

        this.id = id;
        this.name = name;
        this.description = description;
        this.value = value;
        this.activated = activated;
        this.createdAt = createdAt;
    }

    private void validateConstructor(String name, String description, Double value, LocalDateTime createdAt) {
        if (name == null || name != null && name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty or null");

        if (description == null || description != null && description.isEmpty())
            throw new IllegalArgumentException("Description cannot be empty or null");

        if (value == null)
            throw new IllegalArgumentException("Value cannot be null");

        if (value < 0)
            throw new IllegalArgumentException("Value cannot be negative");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }

}
