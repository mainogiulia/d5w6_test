package it.epicode.d5w6_test.trip;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepo tripRepo;

    public List<Trip> findAll() {
        return tripRepo.findAll();
    }

    public Trip findById(Long id) {
        if (!tripRepo.existsById(id)) {
            throw new EntityNotFoundException("Trip not found!");
        }
        return tripRepo.findById(id).get();
    }

    public Trip createTrip(Trip trip) {
        return tripRepo.save(trip);
    }

    public Trip updateTrip(Long id,Trip updatedTrip) {
        Trip trip = findById(id);
        BeanUtils.copyProperties(updatedTrip,trip);
        return tripRepo.save(trip);
    }

    public void deleteTrip(Long id) {
        tripRepo.deleteById(id);
    }
}
