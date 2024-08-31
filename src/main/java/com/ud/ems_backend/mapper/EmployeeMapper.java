package com.ud.ems_backend.mapper;


import com.ud.ems_backend.dto.EmployeeDto;
import com.ud.ems_backend.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee){

        return EmployeeDto
                .builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .dob(employee.getDob())
                .gender(employee.getGender())
                .education(employee.getEducation())
                .experience(employee.getExperience())
                .company(employee.getCompany())
                .packageAmount(employee.getPackageAmount())
                .build();

    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return Employee
                .builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .dob(employeeDto.getDob())
                .gender(employeeDto.getGender())
                .education(employeeDto.getEducation())
                .experience(employeeDto.getExperience())
                .company(employeeDto.getCompany())
                .packageAmount(employeeDto.getPackageAmount())
                .build();
    }
}
