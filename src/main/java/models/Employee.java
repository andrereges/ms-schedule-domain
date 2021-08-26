package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"id", "name", "createAt"})
@ToString(of = {"id", "name"})
public class Employee {

    private String id;
    private String name;
    private List<EmployeeCalendar> calendars;
    private LocalDateTime createdAt;

    public Employee(String id, String name, List<EmployeeCalendar> calendars, LocalDateTime createdAt) {
        validateConstructor(name, createdAt);

        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.calendars = calendars;
    }

    private void validateConstructor(String name, LocalDateTime createdAt) {
        if (name == null || name != null && name.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }
}
