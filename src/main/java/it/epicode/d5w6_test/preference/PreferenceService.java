package it.epicode.d5w6_test.preference;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    @Autowired
    private PreferenceRepo preferenceRepo;

    public List<Preference> findAll() {
        return preferenceRepo.findAll();
    }

    public Preference findById(Long id) {
        if (!preferenceRepo.existsById(id)) {
            throw new EntityNotFoundException("Preference not found!");
        }
        return preferenceRepo.findById(id).get();
    }

    public Preference createPreference(Preference preference) {
        return preferenceRepo.save(preference);
    }

    public Preference updatePreference(Long id,Preference updatedPreference) {
        Preference preference = findById(id);
        BeanUtils.copyProperties(updatedPreference,preference);
        return preferenceRepo.save(preference);
    }

    public void deletePreference(Long id) {
        preferenceRepo.deleteById(id);
    }
}
