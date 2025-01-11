package it.epicode.d5w6_test.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {
		Map<String, String> errors = new HashMap<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
		String fieldName = violation.getPropertyPath().toString();
		if (fieldName.contains(".")) {
		fieldName = fieldName.substring(fieldName.lastIndexOf('.') + 1);
		}
		errors.put(fieldName, violation.getMessage());

		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}

	@ExceptionHandler(value = SameDateException.class)
	protected ResponseEntity<Object> prenotazioneOdierna(SameDateException e) {
		return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
