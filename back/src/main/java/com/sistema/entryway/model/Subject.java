package com.sistema.entryway.model;

import com.sistema.entryway.dto.SubjectDTO;
import com.sistema.entryway.enumeration.SubjectType;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name = "subject")
public class Subject implements UserDetails {
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

    @Column(name = "phone", length = 16)
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    public Subject() {
        this.active = true;
    }

    public Subject(SubjectDTO subject, String password) {
        this();

        this.subjectType = subject.subjectType();
        this.username = subject.username();
        this.name = subject.name();
        this.email = subject.email();
        this.phone = subject.phone();
        this.password = password;
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

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         if (this.subjectType == SubjectType.ADMIN) {
             return List.of(
                     new SimpleGrantedAuthority("ROLE_ADMIN"),
                     new SimpleGrantedAuthority("ROLE_USER")
             );
         } else {
             return List.of(
                     new SimpleGrantedAuthority("ROLE_USER")
             );
         }
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
