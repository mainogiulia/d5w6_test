package it.epicode.d5w6_test.employee;

import it.epicode.d5w6_test.cloudinary.CloudinaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
@Validated
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private CloudinaryService cloudinaryService;

    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    public Employee findById(Long id) {
        if (!employeeRepo.existsById(id)) {
            throw new EntityNotFoundException("Employee not found!");
        }
        return employeeRepo.findById(id).get();
    }

    public Employee createEmployee(@Valid Employee employee, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            Map result = cloudinaryService.uploader(file, "employees");
            employee.setImage(result.get("url").toString());
        }
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

    public Employee uploadImage(Long employeeId, MultipartFile file) {
        Employee employee = findById(employeeId);
        Map uploadResult = cloudinaryService.uploader(file, "employees");
        employee.setImage(uploadResult.get("url").toString());
        return employeeRepo.save(employee);
    }
}
