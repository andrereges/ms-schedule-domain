package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(of = {"id", "calendar", "note", "createdAt"})
public class EmployeeCalendarCanceled {

    private String id;
    private EmployeeCalendar calendar;
    private String note;
    private LocalDateTime createdAt;

    public EmployeeCalendarCanceled(String id, EmployeeCalendar calendar, String note, LocalDateTime createdAt) {
        validateConstructor(calendar, note, createdAt);

        this.id = id;
        this.calendar = calendar;
        this.note = note;
        this.createdAt = createdAt;
    }

    private void validateConstructor(EmployeeCalendar calendar, String note, LocalDateTime createdAt) {
        if (calendar == null)
            throw new IllegalArgumentException("Calendar cannot be null");

        if (note == null || note != null && note.isEmpty())
            throw new IllegalArgumentException("Note cannot be empty or null");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }
}
