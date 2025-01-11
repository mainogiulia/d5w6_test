package it.epicode.d5w6_test.booking;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequest {
    @NotNull(message = "Booking date cannot be empty")
    private LocalDate bookingDate;
    private String employeeNotes;
    @Min(value = 1, message = "Trip id cannot be lower than 1")
    private Long tripId;
    @Min(value = 1, message = "Employee id cannot be lower than 1")
    private Long employeeId;
}
