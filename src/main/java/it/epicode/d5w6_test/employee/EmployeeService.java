package it.epicode.d5w6_test.employee;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new EntityNotFoundException("Employee not found!");
        }
        return employeeRepo.findById(id).get();
    }

    public Employee createEmployee(@Valid Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Long id, @Valid Employee updatedEmployee) {
        Employee employee = findById(id);
        BeanUtils.copyProperties(updatedEmployee,employee);
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }
}
