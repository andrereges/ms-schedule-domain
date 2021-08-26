package models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@EqualsAndHashCode(of = {"id", "runtime", "employee", "procedure", "createdAt"})
@ToString(of = {"id", "runtime", "employee", "procedure"})
public class EmployeeProcedure {

    private String id;
    private LocalTime runtime;
    private Employee employee;
    private Procedure procedure;
    private LocalDateTime createdAt;

    public EmployeeProcedure(String id, LocalTime runtime, Employee employee, Procedure procedure, LocalDateTime createdAt) {
        validateConstructor(runtime, employee, procedure, createdAt);

        this.id = id;
        this.runtime = runtime;
        this.employee = employee;
        this.procedure = procedure;
        this.createdAt = createdAt;
    }

    private void validateConstructor(LocalTime runtime, Employee employee, Procedure procedure, LocalDateTime createdAt) {
        if (runtime == null)
            throw new IllegalArgumentException("Runtime cannot be null");

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
