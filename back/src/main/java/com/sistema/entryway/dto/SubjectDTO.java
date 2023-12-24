package com.sistema.entryway.dto;

import com.sistema.entryway.enumeration.SubjectType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

import static com.sistema.entryway.util.StringUtil.*;
import static jakarta.persistence.EnumType.STRING;

public record SubjectDTO(
        UUID id,
        @Enumerated(STRING)
        SubjectType subjectType,
        String username,
        String name,
        @Email
        String email,
        String phone,
        String password,
        boolean active
    ) {

}
