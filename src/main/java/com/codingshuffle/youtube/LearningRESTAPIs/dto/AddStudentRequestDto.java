package com.codingshuffle.youtube.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AddStudentRequestDto {
    @NotBlank(message = "Name is required!")
    @Size(min = 3, max = 20, message = "Name should be greater than 3 and less than 20")
    private String name;

    @Email
    @NotBlank(message = "Email is required!")
    private String email;
}
