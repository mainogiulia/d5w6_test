package it.epicode.d5w6_test.booking;

import it.epicode.d5w6_test.employee.Employee;
import it.epicode.d5w6_test.trip.Trip;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;
    @Column(name = "employee_notes")
    private String employeeNotes;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}
