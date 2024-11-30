package com.example.backcrud.dto;

import lombok.Builder;

@Builder
public record EmployeeDto(
        String firstName,
        String lastName,
        String email) {
}
