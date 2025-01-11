package it.epicode.d5w6_test.trip;

import it.epicode.d5w6_test.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    @NotBlank(message = "Destination cannot be empty")
    private String destination;
    @Column(name = "trip_date")
    @FutureOrPresent(message = "Trip date cannot be a past date")
    private LocalDate tripDate;
    @Column(name="trip_status")
    @Enumerated(EnumType.STRING)
    private TripStatusEnum tripStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}