package com.sistema.entryway.model;

import com.sistema.entryway.dto.SubjectDTO;
import com.sistema.entryway.enumeration.SubjectType;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID_V1")
    private UUID id;

    @Enumerated(STRING)
    @Column(name = "subject_type", length = 256)
    private SubjectType subjectType;

    @Column(name = "username", nullable = false, length = 40)
    private String username;

    @Column(name = "name", length = 90)
    private String name;

    @Column(name = "email", nullable = false, length = 256)
    private String email;

    @Column(name = "phone", nullable = false, length = 16)
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    public Subject() {
        this.active = true;
    }

    public Subject(SubjectDTO subjectDTO) {
        this();

        this.subjectType = subjectDTO.getSubjectType();
        this.username = subjectDTO.getUsername();
        this.name = subjectDTO.getName();
        this.email = subjectDTO.getEmail();
        this.phone = subjectDTO.getPhone();
        this.password = subjectDTO.getPassword();
    }

    public UUID getId() {
        return id;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public String getUsername() {
        return username;
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

    public Subject mergeForUpdate(Subject subject) {
        this.setName(subject.getName());
        this.setEmail(subject.getEmail());
        this.setPhone(subject.getPhone());

        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(id, subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Subject{" +
               "id=" + id +
               ", subjectType=" + subjectType +
               ", username='" + username + '\'' +
               '}';
    }
}
