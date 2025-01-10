package it.epicode.d5w6_test.preference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {
    @Autowired
    private PreferenceService preferenceService;

    @GetMapping
    public ResponseEntity<List<Preference>> getAllDipendenti(){
        List<Preference> preferences = preferenceService.findAll();
        return ResponseEntity.ok(preferences);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Preference> findPreferenceById(@PathVariable Long id){
        return ResponseEntity.ok(preferenceService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Preference> createPreference(@RequestBody Preference preference) {
        return new ResponseEntity<>(preferenceService.createPreference(preference), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Preference> updatePreference(@PathVariable Long id, @RequestBody Preference updatedPreference) {
        return ResponseEntity.ok(preferenceService.updatePreference(id, updatedPreference));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePreference(@PathVariable Long id) {
        preferenceService.deletePreference(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
