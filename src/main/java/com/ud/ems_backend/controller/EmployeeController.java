package com.ud.ems_backend.controller;

import com.ud.ems_backend.dto.EmployeeDto;
import com.ud.ems_backend.service.EmployeeServiceImpl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    //Build an Add Employee REST Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeServiceImpl.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build GET Employee REST Api
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeServiceImpl.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build GET All Employees REST Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeServiceImpl.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    //Build Update Employee REST Api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updateEmployee){
        EmployeeDto employee = employeeServiceImpl.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, String>> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeServiceImpl.deleteEmployee(employeeId);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Employee deleted successfully :-");

        return ResponseEntity.ok(response);
    }

}
