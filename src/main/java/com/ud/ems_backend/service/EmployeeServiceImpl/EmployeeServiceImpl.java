package com.ud.ems_backend.service.EmployeeServiceImpl;


import com.ud.ems_backend.dto.EmployeeDto;
import com.ud.ems_backend.entity.Employee;
import com.ud.ems_backend.exception.ResourceNotFoundException;
import com.ud.ems_backend.mapper.EmployeeMapper;
import com.ud.ems_backend.repository.EmployeeRepository;
import com.ud.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee does not exist with the given Id : "+employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees =  employeeRepository.findAll();

       return employees.stream().map((EmployeeMapper::mapToEmployeeDto)).collect(Collectors.toList());
    }

//    @Override
//    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id : "+employeeId));
//
//        employee.setFirstName(updateEmployee.getFirstName());
//        employee.setLastName(updateEmployee.getLastName());
//        employee.setEmail(updateEmployee.getEmail());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//
//        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
//    }



    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with the given id : " + employeeId));

        // Update fields only if they are not null or empty
        if (updateEmployee.getFirstName() != null && !updateEmployee.getFirstName().isEmpty()) {
            employee.setFirstName(updateEmployee.getFirstName());
        }

        if (updateEmployee.getLastName() != null && !updateEmployee.getLastName().isEmpty()) {
            employee.setLastName(updateEmployee.getLastName());
        }

        if (updateEmployee.getEmail() != null && !updateEmployee.getEmail().isEmpty()) {
            employee.setEmail(updateEmployee.getEmail());
        }

        if (updateEmployee.getDob() != null && !updateEmployee.getDob().isEmpty()) {
            employee.setDob(updateEmployee.getDob());
        }

        if (updateEmployee.getGender() != null && !updateEmployee.getGender().isEmpty()) {
            employee.setGender(updateEmployee.getGender());
        }

        if (updateEmployee.getEducation() != null && !updateEmployee.getEducation().isEmpty()) {
            employee.setEducation(updateEmployee.getEducation());
        }

        if (updateEmployee.getCompany() != null && !updateEmployee.getCompany().isEmpty()) {
            employee.setCompany(updateEmployee.getCompany());
        }

        if (updateEmployee.getPackageAmount() != null) {
            employee.setPackageAmount(updateEmployee.getPackageAmount());
        }

        if (updateEmployee.getExperience() != null) {
            employee.setExperience(updateEmployee.getExperience());
        }

        Employee updatedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }


    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee does not exist with the given id : "+employeeId));

        employeeRepository.deleteById(employeeId);
    }


}
