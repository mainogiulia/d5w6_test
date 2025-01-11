package it.epicode.d5w6_test.trip;

import it.epicode.d5w6_test.employee.Employee;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String destination;
    @Column(name = "trip_date")
    private LocalDate tripDate;
    @Column(name="trip_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private TripStatusEnum tripStatus;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}