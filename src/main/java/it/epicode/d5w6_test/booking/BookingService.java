package it.epicode.d5w6_test.booking;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    public List<Booking> findAll() {
        return bookingRepo.findAll();
    }

    public Booking findById(Long id) {
        if (!bookingRepo.existsById(id)) {
            throw new EntityNotFoundException("Booking not found!");
        }
        return bookingRepo.findById(id).get();
    }

    public Booking createBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    public Booking updateBooking(Long id,Booking updatedBooking) {
        Booking booking = findById(id);
        BeanUtils.copyProperties(updatedBooking,booking);
        return bookingRepo.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepo.deleteById(id);
    }
}
