package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@EqualsAndHashCode(of = {"id", "date", "employee", "createdAt"})
public class EmployeeCalendar {

    private String id;
    private Employee employee;
    private LocalDate date;
    private List<CalendarTime> calendarTimes;
    private List<Procedure> procedures;
    private LocalDateTime createdAt;

    public EmployeeCalendar(String id, Employee employee, LocalDate date, List<CalendarTime> calendarTimes,
                            List<Procedure> procedures, LocalDateTime createdAt) {
        validateConstructor(employee, date, calendarTimes, procedures, createdAt);

        this.id = id;
        this.employee = employee;
        this.date = date;
        this.calendarTimes = calendarTimes;
        this.procedures = procedures;
        this.createdAt = createdAt;

    }

    private void validateConstructor(Employee employee, LocalDate date, List<CalendarTime> calendarTimes,
                     List<Procedure> procedures, LocalDateTime createdAt) {
        if (employee == null)
            throw new IllegalArgumentException("Employee cannot be null");

        if (date == null)
            throw new IllegalArgumentException("Date cannot be empty or null");

        if (date.isBefore(LocalDate.now()))
            throw new IllegalArgumentException("Date cannot be before now");

        if (calendarTimes.isEmpty())
            throw new IllegalArgumentException("At least one calendar time is required");

        if (procedures.isEmpty())
            throw new IllegalArgumentException("At least one procedure is required");

        if (createdAt == null)
            throw new IllegalArgumentException("CreatedAt cannot be null");

        if (createdAt.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("CreatedAt cannot be before now");
    }

    public void addCalendarTime(CalendarTime calendarTime) {
        this.calendarTimes.add(calendarTime);
    }

    public void deleteCalendarTime(CalendarTime calendarTime) {
        if (calendarTimes.size() <= 1)
            throw new IllegalArgumentException("You can't delete because it must contain at least one calendar time");

        this.calendarTimes.remove(calendarTime);
    }

    public void addProcedure(Procedure procedure) {
        this.procedures.add(procedure);
    }

    public void deleteProcedure(Procedure procedure) {
        if (procedures.size() <= 1)
            throw new IllegalArgumentException("You can't delete because it must contain at least one procedure");

        this.procedures.remove(procedure);
    }
}
