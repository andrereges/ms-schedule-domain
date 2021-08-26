package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"id", "note", "employee", "procedure", "createdAt"})
public class Schedule {

    private String id;
    private LocalDateTime scheduledTime;
    private String note;
    private Client client;
    private Employee employee;
    private Procedure procedure;
    private LocalDateTime createdAt;

    public Schedule(String id, LocalDateTime scheduledTime, String note, Client client,
                    Employee employee, Procedure procedure, LocalDateTime createdAt) {
        validateConstructor(scheduledTime, client, employee, procedure, createdAt);

        this.id = id;
        this.scheduledTime = scheduledTime;
        this.note = note;
        this.client = client;
        this.employee = employee;
        this.procedure = procedure;
        this.createdAt = createdAt;
    }

    private void validateConstructor(LocalDateTime scheduledTime, Client client,
                                     Employee employee, Procedure procedure, LocalDateTime createdAt) {
        if (scheduledTime == null)
            throw new IllegalArgumentException("Scheduled time cannot be null");

        if (scheduledTime.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Scheduled time cannot be less than now");

        if (client == null)
            throw new IllegalArgumentException("Client cannot be null");

        if (employee == null)
            throw new IllegalArgumentException("Employee cannot be null");

        if (procedure == null)
            throw new IllegalArgumentException("Procedure cannot be null");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }
}
