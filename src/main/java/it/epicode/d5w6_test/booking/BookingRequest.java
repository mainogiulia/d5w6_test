package it.epicode.d5w6_test.booking;

import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequest {
    private LocalDate bookingDate;
    private String employeeNotes;
    private Long tripId;
    private Long employeeId;
}
