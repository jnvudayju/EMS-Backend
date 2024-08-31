package com.ud.ems_backend.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String dob;

    private String gender;

    private String education;

    private String company;

    private Long packageAmount;

    private Long experience;

}
