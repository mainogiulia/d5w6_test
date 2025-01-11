package it.epicode.d5w6_test.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    @NotBlank(message = "Username cannot be empty")
    private String username;
    @Column
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @Column
    @NotBlank(message = "Surname cannot be empty")
    private String surname;
    @Column
    @Email(message = "Email has to be a valid email address")
    private String email;
    private String image;
}
