package it.epicode.d5w6_test.booking;

import it.epicode.d5w6_test.employee.Employee;
import it.epicode.d5w6_test.employee.EmployeeService;
import it.epicode.d5w6_test.exceptions.SameDateException;
import it.epicode.d5w6_test.trip.Trip;
import it.epicode.d5w6_test.trip.TripService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private TripService tripService;
    @Autowired
    private EmployeeService employeeService;

    public List<Booking> findAll() {
        return bookingRepo.findAll();
    }

    public Booking findById(Long id) {
        if (!bookingRepo.existsById(id)) {
            throw new EntityNotFoundException("Booking not found!");
        }
        return bookingRepo.findById(id).get();
    }

    public Booking createBooking(BookingRequest bookingRequest) {
        if (bookingRepo.existsByEmployeeAndBookingDate(bookingRequest.getEmployeeId(), bookingRequest.getBookingDate())) {
            throw new SameDateException("Employee already has a booking for this date, please choose another date: " + bookingRequest.getBookingDate());
        }

        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingRequest, booking);
        Trip trip = tripService.findById(bookingRequest.getTripId());
        Employee employee = employeeService.findById(bookingRequest.getEmployeeId());
        booking.setTrip(trip);
        booking.setEmployee(employee);
        return bookingRepo.save(booking);
    }

    public Booking updateBooking(Long id,Booking updatedBooking) {
        Booking booking = findById(id);
        if (bookingRepo.existsByEmployeeAndBookingDate(updatedBooking.getEmployee().getId(), updatedBooking.getBookingDate())) {
            throw new SameDateException("Employee already has a booking for this date, please choose another date: " + updatedBooking.getBookingDate());
        }
        BeanUtils.copyProperties(updatedBooking,booking);
        return bookingRepo.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}
