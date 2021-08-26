package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"id", "schedule", "note", "createdAt"})
public class ScheduleCanceled {

    private String id;
    private Schedule schedule;
    private String note;
    private LocalDateTime createdAt;

    public ScheduleCanceled(String id, Schedule schedule, String note, LocalDateTime createdAt) {
        validateConstructor(schedule, note, createdAt);

        this.id = id;
        this.schedule = schedule;
        this.note = note;
        this.createdAt = createdAt;
    }

    private void validateConstructor(Schedule schedule, String note, LocalDateTime createdAt) {
        if (schedule == null)
            throw new IllegalArgumentException("Schedule cannot be null");

        if (note == null || note != null && note.isEmpty())
            throw new IllegalArgumentException("Note cannot be empty or null");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }
}
