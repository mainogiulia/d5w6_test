package it.epicode.d5w6_test.trip;

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

    @Column(nullable = false)
    private LocalDate date;

    @Column(name="trip_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private TripStatusEnum tripStatus;

}