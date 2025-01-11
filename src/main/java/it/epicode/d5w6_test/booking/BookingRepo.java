package it.epicode.d5w6_test.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    @Query("SELECT COUNT(b) > 0 FROM Booking b WHERE b.employee.id = :employeeId AND b.bookingDate = :bookingDate")
    boolean existsByEmployeeAndBookingDate(@Param("employeeId") Long employeeId, @Param("bookingDate") LocalDate bookingDate);
}
