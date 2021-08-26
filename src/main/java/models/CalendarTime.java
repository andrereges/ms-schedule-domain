package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@EqualsAndHashCode(of = {"id", "createdAt"})
@ToString(of = {"id"})
public class CalendarTime {

    private String id;
    private EmployeeCalendar employeeCalendar;
    private LocalTime startHour;
    private LocalTime endHour;

    public CalendarTime(String id, EmployeeCalendar employeeCalendar, LocalTime startHour, LocalTime endHour) {
        validateConstructor(employeeCalendar, startHour, endHour);

        this.id = id;
        this.employeeCalendar = employeeCalendar;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    private void validateConstructor(EmployeeCalendar employeeCalendar, LocalTime startHour, LocalTime endHour) {
        if (employeeCalendar == null)
            throw new IllegalArgumentException("Calendar cannot be null");

        if (startHour == null)
            throw new IllegalArgumentException("Start hour cannot be negative");

        if (endHour == null)
            throw new IllegalArgumentException("End hour cannot be negative");

        if (startHour.equals(endHour) || startHour.isAfter(endHour))
            throw new IllegalArgumentException("Start hour cannot be equal or less than end hour");

        if (endHour.equals(startHour) || endHour.isBefore(startHour))
            throw new IllegalArgumentException("End hour cannot be equal or greater than start hour");
    }
}
