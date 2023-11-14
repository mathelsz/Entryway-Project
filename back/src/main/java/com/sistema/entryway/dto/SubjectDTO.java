package com.sistema.entryway.dto;

import com.sistema.entryway.enumeration.SubjectType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;

import java.util.UUID;

import static com.sistema.entryway.util.StringUtil.*;
import static jakarta.persistence.EnumType.STRING;

public class SubjectDTO {
    private UUID id;

    @Enumerated(STRING)
    private SubjectType subjectType;

    private String username;

    private String name;

    @Email
    private String email;

    private String phone;

    private String password;

    private boolean active;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getUsername() {
        return removeAccentLower(username);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
