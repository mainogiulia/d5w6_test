package it.epicode.d5w6_test.employee;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmployeeRequest {
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @NotBlank(message = "Name cannot be empty")
    private String nome;
    @NotBlank(message = "Surname cannot be empty")
    private String cognome;
    @Email(message = "Email has to be a valid email address")
    private String email;
    private String image;

}
